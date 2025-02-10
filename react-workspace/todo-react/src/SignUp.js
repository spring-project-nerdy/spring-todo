import React from "react";
import { Container, Grid2, Typography, TextField, Button } from "@mui/material";
import { signup } from "./service/ApiService";
import { Link } from "react-router-dom";

function SignUp() {
  const handleSubmit = (event) => {
    event.preventDefault();
    // 오브젝트에서 formd에 저장된 데이터를 맵의 형태로 바꿔줌.
    const data = new FormData(event.target);
    const username = data.get("username");
    const password = data.get("password");
    signup({ username: username, password: password }).then((reponse) => {
      // 계정 생성 성공 시 login 페이지로 리다이렉트
      window.location.href = "/login";
    });
  };

  return (
    <Container component="main" maxWidth="xs" style={{ marginTop: "8%" }}>
      <form noValidate onSubmit={handleSubmit}>
        <Grid2 container spacing={2}>
          <Grid2 item xs={12}>
            <Typography component="h1" variant="h5">
              계정 생성
            </Typography>
          </Grid2>
          <Grid2 item xs={12}>
            <TextField
              autoComplete="fname"
              name="username"
              variant="outlined"
              required
              fullWidth
              id="username"
              label="아이디"
              autoFocus
            ></TextField>
          </Grid2>
          <Grid2 item xs={12}>
            <TextField
              variant="outlined"
              required
              fullWidth
              name="password"
              id="password"
              label="패스워드"
              type="password"
              autoComplete="current-password"
            ></TextField>
          </Grid2>
          <Grid2 item xs={12}>
            <Button type="submit" fullWidth variant="contained" color="primary">
              계정 생성
            </Button>
          </Grid2>
          <Grid2 container justify="flex-end">
            <Grid2 tiem>
              <Link to="/login" variant="body2">
                이미 계정이 있습니까? 로그인하세요.
              </Link>
            </Grid2>
          </Grid2>
        </Grid2>
      </form>
    </Container>
  );
}
export default SignUp;
