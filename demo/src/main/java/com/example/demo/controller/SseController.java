package com.example.demo.controller;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class SseController {

  @GetMapping("/sse")
  public SseEmitter handleSse() {
    // SseEmitter 객체를 사용하여 클라이언트와의 연결을 유지
    SseEmitter emitter = new SseEmitter();

    // 새로운 쓰레드로 데이터를 보내는 작업을 비동기적으로 실행
    new Thread(() -> {
      try {
        // 1초 간격으로 이벤트 전송 (예시)
        for (int i = 0; i < 10; i++) {
          emitter.send(SseEmitter.event().name("message").data("Hello, client! #" + i));
          TimeUnit.SECONDS.sleep(1);
        }
        emitter.complete(); // 작업이 완료되면 연결을 종료
      } catch (IOException | InterruptedException e) {
        emitter.completeWithError(e); // 오류가 발생하면 연결 종료
      }
    }).start();

    return emitter;
  }
}
