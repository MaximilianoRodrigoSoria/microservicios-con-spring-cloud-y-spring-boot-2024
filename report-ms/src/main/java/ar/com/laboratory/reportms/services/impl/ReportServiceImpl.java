package ar.com.laboratory.reportms.services.impl;

import ar.com.laboratory.reportms.clients.CompaniesClient;
import ar.com.laboratory.reportms.services.ReportService;
import com.netflix.discovery.EurekaClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesClient client;
    private final EurekaClient eurekaClient;

    @Override
    public String makeReport(String name) {
        return null;
    }

    @Override
    public String saveReport(String nameReport) {
        return null;
    }

    @Override
    public void deleteReport(String name) {

    }
}
