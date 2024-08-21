package com.academy;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static DataSource instance;
    private Properties properties = new Properties();
    private ComboPooledDataSource dataSource;

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

    private DataSource() {
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource = new ComboPooledDataSource();

        dataSource.setJdbcUrl(properties.getProperty("db.url"));
        dataSource.setUser(properties.getProperty("db.user"));
        dataSource.setPassword(properties.getProperty("db.password"));

        dataSource.setInitialPoolSize(8);
        dataSource.setMinPoolSize(5);
        dataSource.setMaxPoolSize(10);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}