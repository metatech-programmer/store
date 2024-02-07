package com.project.store.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {
    
    @GetMapping("/estadisticas")
    public String index() {
        return "pages/statistics";
    }
    
}
