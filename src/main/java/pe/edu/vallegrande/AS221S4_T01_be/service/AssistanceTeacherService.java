package pe.edu.vallegrande.AS221S4_T01_be.service;

import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceTeacher;
import pe.edu.vallegrande.AS221S4_T01_be.repository.projections.TeacherWithAttendance;

import java.util.Date;
import java.util.List;

public interface AssistanceTeacherService {

    List<TeacherWithAttendance> findTeachersWithAttendance(String shift, Date attendaceDate);

    void saveAssistance(List<AssistanceTeacher> assistanceTeacher);
}


