package com.github.noticeboard.web.controller;

import com.github.noticeboard.service.AuthService;
import com.github.noticeboard.web.dto.auth.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sign")
public class SignController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody SignUp signUpRequest) {
        boolean isSuccess = authService.signUp(signUpRequest);
        return isSuccess ? "회원가입에 성공하였습니다." : "회원가입에 실패하였습니다.";
    }

}
