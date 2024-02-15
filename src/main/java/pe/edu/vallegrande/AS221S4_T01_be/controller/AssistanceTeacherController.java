package pe.edu.vallegrande.AS221S4_T01_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.vallegrande.AS221S4_T01_be.mapper.AssistanceTeacherMapper;
import pe.edu.vallegrande.AS221S4_T01_be.model.dto.AssistanceTeacherDto;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceTeacher;
import pe.edu.vallegrande.AS221S4_T01_be.repository.projections.TeacherWithAttendance;
import pe.edu.vallegrande.AS221S4_T01_be.service.impl.AssistanceTeacherServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/assistance-teacher")
@RequiredArgsConstructor
public class AssistanceTeacherController {

    private final AssistanceTeacherServiceImpl assistanceTeacherServiceImpl;
    private final AssistanceTeacherMapper assistanceTeacherMapper;

    @GetMapping
    public ResponseEntity<List<TeacherWithAttendance>> findTeachersWithAttendance(@RequestParam String shift,
                                                                                  @RequestParam String attendanceDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date date = formatter.parse(attendanceDate);
        List<TeacherWithAttendance> assistanceTeachers = assistanceTeacherServiceImpl.findTeachersWithAttendance(shift, date);
        return ResponseEntity.ok(assistanceTeachers);
    }


    @PostMapping
    public void saveAssistance(@RequestBody List<AssistanceTeacherDto> request) {
        List<AssistanceTeacher> assistanceTeachers = assistanceTeacherMapper.toEntity(request);
        this.assistanceTeacherServiceImpl.saveAssistance(assistanceTeachers);
    }

}
