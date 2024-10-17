package com.example.Monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class ActivityController {
    @Autowired
    private DataSource dataSource;
    @GetMapping("/")
    private String getInfo() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pg_stat_activity");
             ResultSet rs = stmt.executeQuery()) {
             while (rs.next()) {
                String user = rs.getString("usename");
                String query = rs.getString("query");
                System.out.println(rs.getString(15));
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "GET-INFO";
    }
}
