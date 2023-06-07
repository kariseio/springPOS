package com.example.springpos.dao;

import com.example.springpos.entity.Product;
import com.example.springpos.entity.Receive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ReceiveDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ReceiveDao(DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
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
