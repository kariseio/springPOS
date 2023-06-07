package com.example.springpos.dao;

import com.example.springpos.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

public class SaleDao {
    private Sale sale;

    @Autowired
    public SaleDao(DataSource dataSource) {
        this.sale = sale;
    }


}
