package com.example.Monitoring;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Service
public class ActivityMonitorService {
    @Autowired
    private DataSource dataSource;
    @Scheduled(fixedRate = 6000)
    public void collectActivityData(){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pg_stat_activity");
             ResultSet rs = stmt.executeQuery()) {
             while (rs.next()) {
                // Обработайте результаты и сохраните данные
                String user = rs.getString("usename");
                String query = rs.getString("query");
                // Сохранение данных в свою таблицу
                System.out.println(user + " | " + query);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
