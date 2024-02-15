package pe.edu.vallegrande.AS221S4_T01_be.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceStudent;
import pe.edu.vallegrande.AS221S4_T01_be.repository.AssistanceStudentRepository;
import pe.edu.vallegrande.AS221S4_T01_be.service.AssistanceStudentService;
import pe.edu.vallegrande.AS221S4_T01_be.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssistanceStudentServiceImpl implements AssistanceStudentService {

    private final AssistanceStudentRepository assistanceStudentRepository;
    private final StudentService studentService;

    @Override
    public List<AssistanceStudent> getAll() {
        return assistanceStudentRepository.findAll();
    }

    @Override
    public AssistanceStudent createAssistance(AssistanceStudent assistanceStudent) {
        Long studentId = assistanceStudent.getStudent().getId();
        if (studentService.isStudentActive(studentId)) {
            return assistanceStudentRepository.save(assistanceStudent);
        } else {
            throw new RuntimeException("No se puede crear la asistencia para un estudiante inactivo.");
        }
    }
}
