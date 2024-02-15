package pe.edu.vallegrande.AS221S4_T01_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Student;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class AssistanceStudentDto {
    private Student student;
    private LocalDateTime input;
    private String gradeSection;
    private String states;
    private String shifts;
    private String observation;

}
