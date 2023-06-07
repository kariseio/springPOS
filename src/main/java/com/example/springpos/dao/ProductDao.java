package com.example.springpos.dao;

import com.example.springpos.entity.Member;
import com.example.springpos.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(final Product product) {
        KeyHolder keyHolder= new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement pstmt= con.prepareStatement("insert into PRODUCT (P_NAME, P_QUANTITY, P_PRICE) values (?, ?, ?)",new String[] {"P_CODE"});
                        pstmt.setString(1,  product.getP_name());
                        pstmt.setInt(2,  product.getP_quantity());
                        pstmt.setInt(3,  product.getP_price());
                        return pstmt;
                    }
                }, keyHolder);
        Number keyValue= keyHolder.getKey();
    }

    public List<Product> selectAll() {
        List<Product> results = jdbcTemplate.query("select * from PRODUCT",
                (ResultSet rs, int rowNum) -> {
                    Product product= new Product(rs.getString("P_NAME"),
                            rs.getInt("P_QUANTITY"), rs.getInt("P_PRICE"));

                    return product;
                });
        return results;
    }

    public Product selectByName(String name) {
        List<Product> results = jdbcTemplate.query("select * from PRODUCT where P_NAME = ?",
                new RowMapper<Product>() {
                    @Override
                    public Product mapRow(ResultSet rs, int rowNum)  throws SQLException {
                        Product product = new Product(rs.getInt("P_CODE"),
                                rs.getString("P_NAME"),
                                rs.getInt("P_QUANTITY"),
                                rs.getInt("P_PRICE"));
                        return product;
                    }
                }, name);
        return results.isEmpty() ? null : results.get(0);
    }

}
