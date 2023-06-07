package com.example.springpos.controller;


import com.example.springpos.dao.ProductDao;
import com.example.springpos.dao.ReceiveDao;
import com.example.springpos.entity.Product;
import com.example.springpos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // 상품 페이지
    @GetMapping("/")
    public String product() {
        return "stockManagement/stockManagement";
    }

    // 상품 추가
    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name, @RequestParam("quantity") int quantity, @RequestParam("price") int price) {
        productService.addProduct(name, quantity, price);

        return "redirect:/product";
    }

    // 상품 수정
    @PostMapping("/update")
    public String updateProduct(@RequestParam("code") int code, @RequestParam("name") String name, @RequestParam("quantity") int quantity, @RequestParam("price") int price) {
        productService.updateProduct(code, name, quantity, price);

        return "redirect:/product";
    }

    // 상품 입고
    @PostMapping("/receive/add")
    public String addReceive() {
        return "redirect:/product";
    }

    // 입고 조회
    @GetMapping("/receive/list")
    public String receiveList() {
        return "";
    }
}
