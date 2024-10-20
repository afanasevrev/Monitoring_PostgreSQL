package com.example.Monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
@Controller
public class ActivityController {
    @Autowired
    private DataSource dataSource;
    @GetMapping("/")
    private String getInfo() {
        return "GET-INFO";
    }
}
