package com.example.springpos.dao;

import com.example.springpos.entity.Member;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class MemberDao {
    private JdbcTemplate jdbcTemplate;
    public MemberDao(DataSource dataSource) {
        this.jdbcTemplate= new JdbcTemplate(dataSource);
    }

    public List<Member> selectAll() {
        List<Member> results = jdbcTemplate.query("select * from MEMBER",
                (ResultSet rs, int rowNum) -> {
                    Member member= new Member( rs.getString("ID"), rs.getString("PASSWORD"),
                            rs.getString("NAME"), rs.getString("EMAIL"));
                    return member;
                });
        return results;
    }

    public Member selectByEmail(String email) {
        List<Member> results = jdbcTemplate.query("select * from MEMBER where EMAIL = ?",
                new RowMapper<Member>() {
                    @Override
                    public Member mapRow(ResultSet rs, int rowNum)  throws SQLException {
                        Member member= new Member( rs.getString("ID"),
                                rs.getString("PASSWORD"),
                                rs.getString("NAME"),
                                rs.getString("EMAIL"));
                        return member;
                    }
                }, email);
        return results.isEmpty() ? null : results.get(0);
    }

    public void insert(final Member member) {
        KeyHolder keyHolder= new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement pstmt= con.prepareStatement("insert into MEMBER (ID, PASSWORD, NAME, EMAIL) values (?, ?, ?, ?)",new String[] {"ID"});
                        pstmt.setString(1,  member.getId());
                        pstmt.setString(2,  member.getPassword());
                        pstmt.setString(3,  member.getName());
                        pstmt.setString(4,  member.getEmail());
                        return pstmt;
                    }
                }, keyHolder);
        Number keyValue= keyHolder.getKey();
    }
}
