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
        this.jdbcTemplate= new JdbcTemplate(dataSource);
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

    // 최다 판매 제품
    public String getBestSeller() {
        List<String> results = jdbcTemplate.query("SELECT t1.s_pname, MAX(t1.cumulative_quantity) AS max_cumulative_quantity FROM ( SELECT s_pname, s_quantity, (SELECT SUM(s_quantity) FROM springPOS.SALE t2 WHERE t2.s_pname = t1.s_pname AND t2.s_code <= t1.s_code) AS cumulative_quantity FROM springPOS.SALE t1) t1 GROUP BY t1.s_pname;",
                (ResultSet rs, int rowNum) -> {
                    return rs.getString("t1.s_pname");
                });
        return results.get(0);
    }

    // 일일 판매량 검색
    public List<Sale> selectByDay() {
        List<Sale> results = jdbcTemplate.query("select * from SALE where DATE(S_DATE) = DATE(now())",
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

    // 일일 최다 판매 제품
    public String getBestSellerByDay() {
        List<String> results = jdbcTemplate.query("SELECT t1.s_pname, MAX(t1.cumulative_quantity) AS max_cumulative_quantity FROM ( SELECT s_pname, s_quantity, (SELECT SUM(s_quantity) FROM springPOS.SALE t2 WHERE t2.s_pname = t1.s_pname AND t2.s_code <= t1.s_code) AS cumulative_quantity FROM springPOS.SALE t1 where DATE(S_DATE) = DATE(now()) ) t1 GROUP BY t1.s_pname;",
                (ResultSet rs, int rowNum) -> {
                    return rs.getString("t1.s_pname");
                });
        return results.get(0);
    }

    // 일주일 판매량 검색
    public List<Sale> selectByWeek() {
        List<Sale> results = jdbcTemplate.query("select * from SALE where DATE(S_DATE) >= DATE_SUB(NOW(), INTERVAL 7 DAY)",
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

    // 일주일 최다 판매 제품
    public String getBestSellerByWeek() {
        List<String> results = jdbcTemplate.query("SELECT t1.s_pname, MAX(t1.cumulative_quantity) AS max_cumulative_quantity FROM ( SELECT s_pname, s_quantity, (SELECT SUM(s_quantity) FROM springPOS.SALE t2 WHERE t2.s_pname = t1.s_pname AND t2.s_code <= t1.s_code) AS cumulative_quantity FROM springPOS.SALE t1 where DATE(S_DATE) >= DATE_SUB(NOW(), INTERVAL 7 DAY) ) t1 GROUP BY t1.s_pname;",
                (ResultSet rs, int rowNum) -> {
                    return rs.getString("t1.s_pname");
                });
        return results.get(0);
    }

    // 한달 판매량 검색
    public List<Sale> selectByMonth() {
        List<Sale> results = jdbcTemplate.query("select * from SALE where DATE(S_DATE) >= DATE_SUB(NOW(), INTERVAL 1 MONTH)",
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

    // 한달 최다 판매 제품
    public String getBestSellerByMonth() {
        List<String> results = jdbcTemplate.query("SELECT t1.s_pname, MAX(t1.cumulative_quantity) AS max_cumulative_quantity FROM ( SELECT s_pname, s_quantity, (SELECT SUM(s_quantity) FROM springPOS.SALE t2 WHERE t2.s_pname = t1.s_pname AND t2.s_code <= t1.s_code) AS cumulative_quantity FROM springPOS.SALE t1 where DATE(S_DATE) >= DATE_SUB(NOW(), INTERVAL 1 MONTH) ) t1 GROUP BY t1.s_pname;",
                (ResultSet rs, int rowNum) -> {
                    return rs.getString("t1.s_pname");
                });
        return results.get(0);
    }
}
