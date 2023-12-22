package com.example.sc.config;


import com.example.sc.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example.sc")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    Environment environment;

    private final String URL = "url";
    private final String USER = "dbuser";
    private final String DRIVER = "driver";
    private final String PASSWORD = "dbpassword";

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }


    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        return driverManagerDataSource;
    }

    @Bean
    public Order getOrderRepo(){
        return new OrderImpl(getJdbcTemplate());
    }

    @Bean
    public InfoClient getCustumerDao(){
        return new InfoClientImpl(getJdbcTemplate());
    }

    @Bean
    public Warrantys getRepairDao(){
        return new WarrantysImpl(getJdbcTemplate());
    }

    @Bean
    public Status getTypeRepairDao(){
        return new StatusImpl(getJdbcTemplate());
    }

    @Bean
    public Detail getPartDao(){
        return new DetailImpl(getJdbcTemplate());
    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getJdbcTemplate());
    }

}
