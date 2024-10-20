package com.example.Monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.sql.DataSource;
import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private DataSource dataSource;
    @GetMapping("/")
    private String getInfo(Model model) {
        List<EventsEntity> listEvents = ActivityMonitorService.listEvents;
        model.addAttribute("listEvents", listEvents);
        return "main";
    }
}
