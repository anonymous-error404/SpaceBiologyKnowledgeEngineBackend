package org.nasaspaceapps.spacebiologyknowledgeenginebackend.Controllers;

import org.nasaspaceapps.spacebiologyknowledgeenginebackend.Services.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/years")
    public ResponseEntity<Map<String,List<Integer[]>>> getYearsCount() {
      return ResponseEntity.ok(Collections.singletonMap("years_list",dashboardService.getYearsCount()));
    }

    @GetMapping("/topviewed")
    public ResponseEntity<Map<String,List<String[]>>> getTopViewedPapers() {
        return ResponseEntity.ok(Collections.singletonMap("top_viewed", dashboardService.getMostViewedPapers()));
    }

}
