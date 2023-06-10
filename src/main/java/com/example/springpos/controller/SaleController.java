package com.example.springpos.controller;

import com.example.springpos.entity.Product;
import com.example.springpos.service.ProductService;
import com.example.springpos.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class SaleController {
    private ProductService productService;
    private SaleService saleService;

    @Autowired
    public SaleController(ProductService productService, SaleService saleService) {
        this.productService = productService;
        this.saleService = saleService;
    }

    // 판매
    @GetMapping("/sale")
    public String saleGet(Model model) {
        model.addAttribute("productlist", productService.productList());

        return "sale/sale";
    }

    // 판매 처리
    @PostMapping("/sale")
    public String sale(@RequestParam("s_pname") String name, @RequestParam("s_date") Timestamp date, @RequestParam("s_quantity") int quantity, @RequestParam("s_price") int price) {
        saleService.addSale(name, date, quantity, price);

        return "redirect:/";
    }
}
