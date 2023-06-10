package com.example.springpos.service;

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
    public Product addProductDomain(String name, int quantity, int price) {
        Product product = new Product(productDao.selectByName(name).getP_code(),name, quantity, price);

        productDao.insert(product);

        return product;
    }

    // 상품 수정
    public void updateProductDomain(int code, String name, int quantity, int price) {
        productDao.update(code, name, quantity, price);
    }

    // 상품 입고
    public void addProduct(int p_code, Timestamp date, int quantity) {
        receiveDao.insert(p_code, date, quantity);
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
