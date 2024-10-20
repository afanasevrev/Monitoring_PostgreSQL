package com.example.Monitoring;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityMonitorService {
    public static List<EventsEntity> listEvents = new ArrayList<>();
    @Autowired
    private DataSource dataSource;
    @Scheduled(fixedRate = 60000)
    public void collectActivityData(){
        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM pg_stat_activity");
             ResultSet rs = stmt.executeQuery()) {
                listEvents.clear();
             while (rs.next()) {
                // Обработайте результаты и сохраните данные
                String user = rs.getString("usename");
                String query = rs.getString("query");
                String query_start = rs.getString("query_start");
                String client_addr = rs.getString("client_addr");
                String application_name = rs.getString("application_name");

                listEvents.add(new EventsEntity(user, query, query_start, client_addr, application_name));

                //System.out.println(user + " | " + query + " | " + query_start + " | " + client_addr + " | " + application_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
