package com.example.springpos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sale")
@Controller
public class SaleController {

    @GetMapping("/")
    public String sale() {
        return "saleInfo/saleInfo";
    }

}
