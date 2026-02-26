package org.example.hotel.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {

    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();

        // 1. Updated JDBC URL for PostgreSQL
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/hotel_DB");

        // 2. Database credentials (update these to match your Postgres setup)
        config.setUsername("postgres");
        config.setPassword("Pramodaya17");

        // 3. PostgreSQL Driver Class
        config.setDriverClassName("org.postgresql.Driver");

        // Connection pool settings
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(30000);
        config.setConnectionTimeout(20000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closePool() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}