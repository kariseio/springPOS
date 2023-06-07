package com.example.springpos.controller;

import com.example.springpos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/statistics")
@Controller
public class StatisticsController {
    ProductService productService;

    @Autowired
    public StatisticsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String statistics() {
        return "statistics/statistics";
    }

    // 판매량
    @PostMapping("/day")
    public String day() {
        return "statistics/statistics";
    }
}
