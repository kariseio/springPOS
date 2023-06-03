package com.example.springpos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "POSMain";
    }

    // 회원가입
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // 회원가입 완료
    @GetMapping("/registerSuccess")
    public String registerSuccess() {
        return "registerSuccess";
    }

    // 로그인
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 비밀번호 확인
    @GetMapping("/pwCheck")
    public String pwCheck() {
        return "passwordCheck";
    }

    // 비밀번호 변경
    @GetMapping("/pwChange")
    public String pwChange() {
        return "passwordChange";
    }

    // 비밀번호 변경 성공
    @GetMapping("/pwChangeSuccess")
    public String pwChangeSuccess(){
        return "passwordChangeSuccess";
    }

    // 계정삭제
    @GetMapping("/deleteMember")
    public String delete() {
        return "deleteMember";
    }


}
