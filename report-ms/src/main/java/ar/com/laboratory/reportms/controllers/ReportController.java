package ar.com.laboratory.reportms.controllers;

import org.springframework.http.ResponseEntity;

import java.rmi.NoSuchObjectException;
import java.util.Map;

public interface ReportController {


    public ResponseEntity<Map<String,String>> getReport(String name) throws NoSuchObjectException;
}
