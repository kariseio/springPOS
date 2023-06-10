package com.example.springpos.dao;

import com.example.springpos.entity.Product;
import com.example.springpos.entity.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class SaleDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SaleDao(DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 판매 추가
    public void insert(String pname, Timestamp date, int quantity, int price) {
        KeyHolder keyHolder= new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement pstmt= con.prepareStatement("insert into SALE (S_PNAME, S_DATE, S_QUANTITY, S_PRICE) values (?, ?, ?, ?)",new String[] {"S_CODE"});
                        pstmt.setString(1,  pname);
                        pstmt.setTimestamp(2,  date);
                        pstmt.setInt(3,  quantity);
                        pstmt.setInt(4, price);
                        return pstmt;
                    }
                }, keyHolder);
        Number keyValue= keyHolder.getKey();
    }

    // 판매 전체 리스트
    public List<Sale> selectAll() {
        List<Sale> results = jdbcTemplate.query("select * from SALE",
                (ResultSet rs, int rowNum) -> {
                    Sale sale= new Sale(rs.getInt("S_CODE"),
                            rs.getString("S_PNAME"),
                            rs.getTimestamp("S_DATE"),
                            rs.getInt("S_QUANTITY"),
                            rs.getInt("S_PRICE"));
                    return sale;
                });
        return results;
    }

    // 코드로 판매 찾기
    public Sale selectByCode(int code) {
        List<Sale> results = jdbcTemplate.query("select * from SALE where S_CODE = ?",
                new RowMapper<Sale>() {
                    @Override
                    public Sale mapRow(ResultSet rs, int rowNum)  throws SQLException {
                        Sale sale = new Sale(rs.getInt("S_CODE"),
                                rs.getString("S_PNAME"),
                                rs.getTimestamp("S_DATE"),
                                rs.getInt("S_QUANTITY"),
                                rs.getInt("S_PRICE"));
                        return sale;
                    }
                }, code);
        return results.isEmpty() ? null : results.get(0);
    }

    // 상품명으로 판매 찾기
    public Sale selectByName(String name) {
        List<Sale> results = jdbcTemplate.query("select * from SALE where S_PNAME = ?",
                new RowMapper<Sale>() {
                    @Override
                    public Sale mapRow(ResultSet rs, int rowNum)  throws SQLException {
                        Sale sale = new Sale(rs.getInt("S_CODE"),
                                rs.getString("S_PNAME"),
                                rs.getTimestamp("S_DATE"),
                                rs.getInt("S_QUANTITY"),
                                rs.getInt("S_PRICE"));
                        return sale;
                    }
                }, name);
        return results.isEmpty() ? null : results.get(0);
    }
}
