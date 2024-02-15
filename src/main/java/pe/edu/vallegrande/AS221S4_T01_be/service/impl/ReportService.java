package pe.edu.vallegrande.AS221S4_T01_be.service.impl;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T01_be.model.dto.TeacherResponseDto;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    public byte[] exportJasperReportTeacher(List<TeacherResponseDto> teacherList) throws JRException, IOException {
        JasperReport jasperReport = JasperCompileManager.compileReport(getClass().getResourceAsStream("/ReporteJaspersoft/TeacherReport.jrxml"));
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(teacherList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Simplifying Tech");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}