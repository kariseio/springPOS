package com.example.springpos.controller;

import com.example.springpos.RegisterRequest;
import com.example.springpos.entity.Member;
import com.example.springpos.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    // 계정 관리 페이지
    @GetMapping("/account")
    public String account() {
        return "accountManagement/accountManagement";
    }

    // 회원가입 페이지
    @GetMapping("/register")
    public String register() {
        return "register/register";
    }

    // 회원가입 처리
    @PostMapping("/registerSuccess")
    public String register(RegisterRequest registerRequest) {
        try {
            memberService.regist(registerRequest);
            return "register/registerSuccess";
        } catch (Exception ex) {
            return "register/register";
        }
    }

    // 회원가입 완료
    @GetMapping("/registerSuccess")
    public String registerSuccess() {
        return "register/registerSuccess";
    }

    // 로그인
    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("password") String pw) {
        Member member = memberService.getMemberById(id);

        if(member == null || !member.getPassword().equals(pw)) {
            return "redirect:/login";
        }

        session.setAttribute("Member", member);

        return "POSMain";
    }

    // 로그아웃
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/"; // 로그아웃 후 리다이렉트할 경로
    }

    // 비밀번호 확인
    @GetMapping("/passwordCheck")
    public String pwCheck(HttpSession session) {
        if(session.getAttribute("Member") == null) {
            return "redirect:/";
        }
        return "accountManagement/passwordCheck";
    }

    // 비밀번호 변경 Get
    @GetMapping("/passwordChange")
    public String pwChangeGet() {

        return "accountManagement/passwordChange";
    }

    // 비밀번호 변경
    @PostMapping("/passwordChange")
    public String pwChange(@RequestParam("password") String pw, HttpSession session) {
        if(pw == null) {
            return "accountManagement/passwordCheck";
        } else {
            String id = ((Member) session.getAttribute("Member")).getId();
            String password = memberService.getPassword(id);

            if(!pw.equals(password)) {
                return "accountManagement/passwordCheck";
            } else {
                return "redirect:/passwordChange";
            }
        }
    }

    // 비밀번호 변경 성공
    @PostMapping("/passwordChangeSuccess")
    public String pwChangeSuccess(@RequestParam("newPassword") String newPW, HttpSession session) {
        String id = ((Member) session.getAttribute("Member")).getId();

        if(newPW != null && id != null) {
            memberService.changePW(id, newPW);
            return "accountManagement/passwordChangeSuccess";
        } else {
            return "redirect:/passwordChange";
        }
    }
}
