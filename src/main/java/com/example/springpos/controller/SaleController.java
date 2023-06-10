package com.example.springpos.controller;

import com.example.springpos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaleController {
    private ProductService productService;

    @Autowired
    public SaleController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/sale")
    public String sale(Model model) {
        model.addAttribute("productlist", productService.productList());

        return "sale/sale";
    }
}
