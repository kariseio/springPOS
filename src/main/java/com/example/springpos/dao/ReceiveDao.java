package com.example.springpos.dao;

import com.example.springpos.entity.Product;
import com.example.springpos.entity.Receive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class ReceiveDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ReceiveDao(DataSource dataSource) {
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }

    public void insert(int p_code, Timestamp date, int quantity) {
        KeyHolder keyHolder= new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement pstmt= con.prepareStatement("insert into RECEIVE (P_CODE, RE_DATE, RE_QUANTITY) values (?, ?, ?)",new String[] {"RE_CODE"});
                        pstmt.setInt(1,  p_code);
                        pstmt.setTimestamp(2,  date);
                        pstmt.setInt(3,  quantity);
                        return pstmt;
                    }
                }, keyHolder);
        Number keyValue= keyHolder.getKey();
    }

    public List<Receive> selectAll() {
        List<Receive> results = jdbcTemplate.query("select * from RECEIVE",
                (ResultSet rs, int rowNum) -> {
                    Receive receive= new Receive(rs.getInt("RE_CODE"),
                            rs.getInt("P_CODE"),
                            rs.getTimestamp("RE_DATE"),
                            rs.getInt("RE_QUANTITY"));
                    return receive;
                });
        return results;
    }

    public Receive selectByPCode(String code) {
        List<Receive> results = jdbcTemplate.query("select * from RECEIVE where P_CODE = ?",
                new RowMapper<Receive>() {
                    @Override
                    public Receive mapRow(ResultSet rs, int rowNum)  throws SQLException {
                        Receive receive = new Receive(rs.getInt("RE_CODE"),
                                rs.getInt("P_CODE"),
                                rs.getTimestamp("RE_DATE"),
                                rs.getInt("RE_QUANTITY"));
                        return receive;
                    }
                }, code);
        return results.isEmpty() ? null : results.get(0);
    }
}
