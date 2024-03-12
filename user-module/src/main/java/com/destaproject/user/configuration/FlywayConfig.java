package com.destaproject.user.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flywayMigration(DataSource datasource) {
        var flyway = Flyway.configure()
                .dataSource(datasource)
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
        return flyway;
    }
}

