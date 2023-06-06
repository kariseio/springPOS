package com.example.springpos.controller;

import com.example.springpos.RegisterRequest;
import com.example.springpos.entity.Member;
import com.example.springpos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private MemberService memberService;

    @Autowired
    public MainController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 메인 페이지
    @GetMapping("/")
    public String index() {
        return "POSMain";
    }

    // 회원가입 페이지
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    // 회원가입 처리
    @PostMapping("/registerSuccess")
    public String register(RegisterRequest registerRequest) {
        try {
            memberService.regist(registerRequest);
            return "registerSuccess";
        } catch (Exception ex) {
            return "register";
        }
    }

    // 회원가입 완료
    @GetMapping("/registerSuccess")
    public String registerSuccess() {
        return "registerSuccess";
    }

    // 로그인
    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @RequestParam("id") String id, @RequestParam("password") String pw) {
        Member member = memberService.getMemberById(id);

        if(member == null) {
            return "/login";
        }

        model.addAttribute("Member", id);
        return "/";
    }

    // 비밀번호 확인
    @GetMapping("/pwCheck")
    public String pwCheck() {
        return "passwordCheck";
    }

    // 비밀번호 변경
    @PostMapping("/pwChange")
    public String pwChange(@RequestParam("newPassword") String pw, Model model) {
        if(pw == null) {
            return "passwordCheck";
        } else {
            String id = (String)model.getAttribute("Member");
            String password = memberService.getPassword(id);

            if(pw == password) {
                return "passwordCheck";
            } else {
                // 비밀번호 맞으면
                return "pwChange";
            }
        }
    }

    // 비밀번호 변경 성공
    @PostMapping("/pwChangeSuccess")
    public String pwChangeSuccess(@RequestParam("newPassword") String newPW, Model model) {
        String id = (String)model.getAttribute("Member");

        if(newPW != null && id != null) {
            memberService.changePW(id, newPW);
            return "passwordChangeSuccess";
        } else {
            return "pwChange";
        }
    }

    // 계정삭제
    @GetMapping("/deleteMember")
    public String delete() {
        return "deleteMember";
    }


}