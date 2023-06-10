package com.example.springpos.service;

import com.example.springpos.dao.ProductDao;
import com.example.springpos.dao.SaleDao;
import com.example.springpos.entity.Product;
import com.example.springpos.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

public class SaleService {
    private ProductDao productDao;
    private SaleDao saleDao;

    @Autowired
    public SaleService(ProductDao productDao, SaleDao saleDao) {
        this.productDao = productDao;
        this.saleDao = saleDao;
    }

    // 판매 추가
    public void addSale(String name, Timestamp date, int quantity, int price) {
        saleDao.insert(name, date, quantity, price);
    }

    public Sale getSaleByCode(int code) {
        Sale sale = saleDao.selectByCode(code);

        return sale;
    }
}
