package com.example.springpos.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ProductDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
    }


}
