package ar.com.laboratory.reportms.services.impl;

import ar.com.laboratory.reportms.clients.CompaniesClient;
import ar.com.laboratory.reportms.services.ReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.rmi.NoSuchObjectException;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesClient companiesClient;


    @Override
    public String makeReport(String name){
        return companiesClient.get(name).orElseThrow().getName();

    }

    @Override
    public String saveReport(String nameReport) {
        return null;
    }

    @Override
    public void deleteReport(String name) {

    }
}
