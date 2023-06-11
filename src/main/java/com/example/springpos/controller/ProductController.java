package com.example.springpos.controller;


import com.example.springpos.dao.ProductDao;
import com.example.springpos.dao.ReceiveDao;
import com.example.springpos.entity.Product;
import com.example.springpos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;

@Controller
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // 상품 재고 관리 페이지
    @GetMapping("/stockManagement")
    public String product(Model model) {
        return "stockManagement/stockManagement";
    }

    // 상품 추가 get
    @GetMapping("/addProductDomain")
    public String addProductDomainGet() {

        return "stockManagement/addProductDomain";
    }

    // 상품 추가 post
    @PostMapping("/addProductDomain")
    public String addProductDomain(@RequestParam("p_name") String name, @RequestParam("p_quantity") int quantity, @RequestParam("p_price") int price) {
        productService.addProductDomain(name, quantity, price);

        return "redirect:/stockManagement";
    }

    // 상품 수정 get
    @GetMapping("/updateProduct")
    public String updateProductGet(Model model) {
        model.addAttribute("productlist", productService.productList());

        return "stockManagement/updateProduct";
    }

    // 상품 수정
    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam("p_code") int code, @RequestParam("p_name") String name, @RequestParam("p_quantity") int quantity, @RequestParam("p_price") int price) {
        productService.updateProductDomain(code, name, quantity, price);

        return "redirect:/stockManagement";
    }

    // 상품 입고 Get
    @GetMapping("/addProduct")
    public String addProductGet(Model model) {
        model.addAttribute("productlist", productService.productList());

        return "stockManagement/addProduct";
    }

    // 상품 입고
    @PostMapping("/addProduct")
    public String addProduct(@RequestParam("p_code") int code, @RequestParam("re_date") Timestamp date, @RequestParam("re_quantity") int quantity) {
        productService.addProduct(code, date, quantity);

        return "redirect:/stockManagement";
    }

    // 입고 조회
    @GetMapping("/receiveInquiry")
    public String receiveList(Model model) {
        model.addAttribute("receiveList", productService.receiveList());

        return "stockManagement/receiveInquiry";
    }
}
