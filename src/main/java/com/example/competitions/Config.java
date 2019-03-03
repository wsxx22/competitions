package com.example.competitions;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Bean
    public DataSource getDataSource () {

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:mysql://77.55.192.67:3306/wsx22_competitions");
        dataSourceBuilder.username("wsx22");
        dataSourceBuilder.password("wsx22");
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        return dataSourceBuilder.build();
    }

    //jdbc template (nakladka) - pozwala z wykorzystaniem datasource komunikować się z baza danych
    // beda na nim sie wykonywac wszystkie zapytania ktore ida do bazy danych

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

}
