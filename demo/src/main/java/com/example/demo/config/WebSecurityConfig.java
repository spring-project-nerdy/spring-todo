package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import com.example.demo.security.OAuthSuccessHandler;
import com.example.demo.security.OAuthUserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    @Autowired
    private OAuthUserServiceImpl oAuthUserService;
    
    @Autowired
    private OAuthSuccessHandler oAuthSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http 시큐리티 빌더
        http.cors() // WebMvcConfig에서 이미 설정했으므로 기본 cors 설정.
            .and()
            .csrf() // csrf는 현재 사용하지 않으므로 disable
            .disable()
            .httpBasic()  // token 을 사용하므로 basic 인증 disable
            .disable()
            .sessionManagement() // session 기반이 아님을 선언
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests() // /와 /auth/** 경로는 인증 안 해도 됨.
            .antMatchers("/", "/auth/**", "/oauth2/**").permitAll() // oauth2 앤드포인트 추가
            .anyRequest() // /와 /auth/**이외의 모든 경로는 인증해야됨.
            .authenticated()
            .and()
            .oauth2Login() // oauth2Login 설정
            .redirectionEndpoint()
            .baseUri("/oauth2/callback/*") // callback uri 설정;
            .and()
            .userInfoEndpoint()
            .userService(oAuthUserService) // OAuthUserServiceImpl를 유저 서비스로 등록
            .and()
            .successHandler(oAuthSuccessHandler);

        // filter 등록.
        // 매 요청마다.
        // CorsFilter 실행한 후에
        // jwtAuthenticationFilter 실행한다.
        http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);
    }
}
