package com.example.springpos.service;

import com.example.springpos.dao.ProductDao;
import com.example.springpos.dao.ReceiveDao;
import com.example.springpos.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
    private ProductDao productDao;
    private ReceiveDao receiveDao;

    @Autowired
    public ProductService(ProductDao productDao, ReceiveDao receiveDao) {
        this.productDao = productDao;
        this.receiveDao = receiveDao;
    }

    // 상품 추가
    public Product addProduct(String name, int quantity, int price) {
        Product product = new Product(productDao.selectByName(name).getP_code(),name, quantity, price);

        productDao.insert(product);
    }
}
