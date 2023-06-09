package com.example.springpos;

import com.example.springpos.dao.MemberDao;
import com.example.springpos.dao.ProductDao;
import com.example.springpos.dao.ReceiveDao;
import com.example.springpos.dao.SaleDao;
import com.example.springpos.service.MemberService;
import com.example.springpos.service.ProductService;
import com.example.springpos.service.SaleService;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
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
    public MemberService memberService(){
        return new MemberService(memberDao());
    }
    @Bean
    public ProductDao productDao() {
        return new ProductDao(dataSource());
    }
    @Bean
    public ReceiveDao receiveDao() {
        return new ReceiveDao(dataSource());
    }
    @Bean
    public ProductService productService() {
        return new ProductService(productDao(), receiveDao());}
    @Bean
    public SaleDao saleDao() {
        return new SaleDao(dataSource());}
    @Bean
    public SaleService saleService() {
        return new SaleService(productDao(), saleDao());}
}
