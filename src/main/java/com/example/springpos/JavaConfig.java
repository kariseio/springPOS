package com.example.springpos;

import com.example.springpos.dao.MemberDao;
import com.example.springpos.dao.ProductDao;
import com.example.springpos.service.MemberService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost/springPOS?characterEncoding=utf8&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("1234");
        ds.setInitialSize(2);
        ds.setMaxActive(10);
        ds.setTestWhileIdle(true);
        ds.setMinEvictableIdleTimeMillis(60000 * 3);
        ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
        return ds;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }
    @Bean
    public MemberService memberRegSvc(){
        return new MemberService(memberDao());
    }
    @Bean
    public ProductDao productDao() {
        return new ProductDao(dataSource());
    }

}
