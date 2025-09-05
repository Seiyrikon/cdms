package org.seiyrikon.cdms_be.service;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {
    Long countEmployeesByDepartment(Long id);
    void exportToCsv(HttpServletResponse response) throws IOException;
}
