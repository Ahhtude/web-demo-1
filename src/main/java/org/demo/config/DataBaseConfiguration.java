package org.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {
    @Bean(name = "DataBaseFirst")
    public DataSource createDataSource(){
       DriverManagerDataSource ds = new DriverManagerDataSource();
       ds.setDriverClassName("org.h2.Driver");
       ds.setUrl("jdbc:h2:~/test;AUTO_SERVER=TRUE");
       return ds;
    }

    @Bean(name = "DataBaseSecond")
    public DataSource createDataSource2(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:~/test;AUTO_SERVER=TRUE");
        return ds;
    }

    @Bean(name = "DataBaseFirstJDBC")
    public JdbcTemplate createTemplate(@Qualifier("DataBaseFirst") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


}
