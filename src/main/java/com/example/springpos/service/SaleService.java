package com.example.springpos.service;

import com.example.springpos.dao.SaleDao;
import org.springframework.beans.factory.annotation.Autowired;

public class SaleService {
    private SaleDao saleDao;

    @Autowired
    public SaleService(SaleDao saleDao) {
        this.saleDao = saleDao;
    }
}
