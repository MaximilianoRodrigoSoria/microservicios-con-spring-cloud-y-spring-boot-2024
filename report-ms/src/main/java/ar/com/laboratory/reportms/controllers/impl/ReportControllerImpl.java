package ar.com.laboratory.reportms.controllers.impl;

import ar.com.laboratory.reportms.controllers.ReportController;
import ar.com.laboratory.reportms.services.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.NoSuchObjectException;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/report")
@AllArgsConstructor
public class ReportControllerImpl implements ReportController {

    private ReportService reportService;

    @Override
    @GetMapping("/{name}")
    public ResponseEntity<Map<String, String>> getReport(@PathVariable String name) throws NoSuchObjectException {
        var response = Map.of("report", reportService.makeReport(name));
        return ResponseEntity.ok(response);
    }
}
