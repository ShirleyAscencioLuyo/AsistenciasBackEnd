package pe.edu.vallegrande.AS221S4_T01_be.controller;

import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S4_T01_be.mapper.TeacherMapper;
import pe.edu.vallegrande.AS221S4_T01_be.model.dto.TeacherResponseDto;
import pe.edu.vallegrande.AS221S4_T01_be.service.impl.ReportService;
import pe.edu.vallegrande.AS221S4_T01_be.service.impl.TeacherServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ReportController {
    private final ReportService service;
    private final TeacherMapper teacherMapper;
    private final TeacherServiceImpl teacherService;
    @GetMapping("/teacher-pdf")
    public ResponseEntity<byte[]> createPDF(@RequestParam(defaultValue = "A") String estado) throws JRException, IOException {
        String currentDateTime = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());
        List<TeacherResponseDto> teachers;

        if (Objects.equals(estado, "A")) {
            teachers = teacherService.listA().stream().map(teacherMapper::toDto).toList();
        } else {
            teachers = teacherService.listI().stream().map(teacherMapper::toDto).toList();
        }

        byte[] pdfBytes = service.exportJasperReportTeacher(teachers);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "pdf_ReporteTeacher_" + currentDateTime + "_" + ".pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}

