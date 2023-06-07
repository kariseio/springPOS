package com.example.springpos.controller;


import com.example.springpos.dao.ProductDao;
import com.example.springpos.dao.ReceiveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    ProductDao  productDao;
    ReceiveDao receiveDao;

    @Autowired
    public ProductController(ProductDao productDao, ReceiveDao receiveDao) {
        this.productDao = productDao;
        this.receiveDao = receiveDao;
    }

    // 상품 페이지
    @GetMapping("/")
    public String product() {
        return "/product";
    }

    // 상품 추가
    @PostMapping("/add")
    public String addProduct() {
        

        return "/product";
    }
    // 상품 수정
    // 입고 조회
    // 상품 입고
    // 판매량
}
