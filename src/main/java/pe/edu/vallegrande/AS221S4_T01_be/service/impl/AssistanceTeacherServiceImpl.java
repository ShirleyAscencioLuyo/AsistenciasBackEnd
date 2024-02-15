package pe.edu.vallegrande.AS221S4_T01_be.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceTeacher;
import pe.edu.vallegrande.AS221S4_T01_be.repository.AssistanceTeacherRepository;
import pe.edu.vallegrande.AS221S4_T01_be.repository.projections.TeacherWithAttendance;
import pe.edu.vallegrande.AS221S4_T01_be.service.AssistanceTeacherService;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssistanceTeacherServiceImpl implements AssistanceTeacherService {

    private final AssistanceTeacherRepository assistanceTeacherRepository;

    @Override
    public List<TeacherWithAttendance> findTeachersWithAttendance(String shift, Date attendanceDate) {
        return assistanceTeacherRepository.findTeachersWithAttendance(shift, attendanceDate);
    }

    @Override
    public void saveAssistance(List<AssistanceTeacher> assistanceTeacher) {
        for (AssistanceTeacher assistanceTeacher1 : assistanceTeacher) {
            this.assistanceTeacherRepository.save(assistanceTeacher1);
        }
    }
}
