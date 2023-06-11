package com.example.springpos.service;

import com.example.springpos.dao.ProductDao;
import com.example.springpos.dao.SaleDao;
import com.example.springpos.entity.Product;
import com.example.springpos.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

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
        Product product = productDao.selectByName(name);
        saleDao.insert(name, date, quantity, price);
        productDao.update(product.getP_code(), name, product.getP_quantity() - quantity, product.getP_price());
    }

    public Sale getSaleByCode(int code) {
        Sale sale = saleDao.selectByCode(code);

        return sale;
    }

    // 판매 리스트
    public List<Sale> getSaleList() {
        List<Sale> list = saleDao.selectAll();

        return list;
    }

    // 전체 최대 판매 제품
    public String getBestSeller() {
        return saleDao.getBestSeller();
    }

    // 일일 판매량
    public List<Sale> getSaleListByDay() {
        List<Sale> list = saleDao.selectByDay();

        return list;
    }

    // 일일 최대 판매 제품
    public String getBestSellerByDay() {
        return saleDao.getBestSellerByDay();
    }

    // 일주일 판매량
    public List<Sale> getSaleListByWeek() {
        List<Sale> list = saleDao.selectByWeek();

        return list;
    }

    // 일주일 최대 판매 제품
    public String getBestSellerByWeek() {
        return saleDao.getBestSellerByWeek();
    }

    // 한달 판매량
    public List<Sale> getSaleListByMonth() {
        List<Sale> list = saleDao.selectByMonth();

        return list;
    }

    // 한달 최대 판매 제품
    public String getBestSellerByMonth() {
        return saleDao.getBestSellerByMonth();
    }
}
