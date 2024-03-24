package ar.com.laboratory.reportms.services;

import java.rmi.NoSuchObjectException;

public interface ReportService {
    String makeReport(String name) throws NoSuchObjectException;
    String saveReport(String nameReport);
    void deleteReport(String name);
}
