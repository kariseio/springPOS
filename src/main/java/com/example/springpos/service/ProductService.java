package com.example.springpos.service;

import com.example.springpos.controller.ProductController;
import com.example.springpos.dao.ProductDao;
import com.example.springpos.dao.ReceiveDao;
import com.example.springpos.entity.Product;
import com.example.springpos.entity.Receive;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

public class ProductService {
    private ProductDao productDao;
    private ReceiveDao receiveDao;

    @Autowired
    public ProductService(ProductDao productDao, ReceiveDao receiveDao) {
        this.productDao = productDao;
        this.receiveDao = receiveDao;
    }

    // 상품 추가
    public void addProductDomain(String name, int quantity, int price) {
        productDao.insert(name, quantity, price);

    }

    // 상품 수정
    public void updateProductDomain(int code, String name, int quantity, int price) {
        productDao.update(code, name, quantity, price);
    }

    // 상품 입고
    public void addProduct(int p_code, Timestamp date, int quantity) {
        Product product = getProductByCode(p_code);
        receiveDao.insert(p_code, date, quantity);
        updateProductDomain(p_code, product.getP_name(), product.getP_quantity() + quantity, product.getP_price());
    }

    // 코드로 상품 찾기
    public Product getProductByCode(int p_code) {
        Product product = productDao.selectByCode(p_code);

        return product;
    }

    // 상품명으로 상품 찾기
    public Product getProductByName(String p_name) {
        Product product = productDao.selectByName(p_name);

        return product;
    }

    // 상품 리스트
    public List<Product> productList() {
        List<Product> list = productDao.selectAll();

        return list;
    }

    // 입고 리스트
    public List<Receive> receiveList() {
        List<Receive> list = receiveDao.selectAll();

        return list;
    }
}
