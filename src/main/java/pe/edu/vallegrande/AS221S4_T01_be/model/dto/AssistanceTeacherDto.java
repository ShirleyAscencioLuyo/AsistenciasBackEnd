package pe.edu.vallegrande.AS221S4_T01_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AssistanceTeacherDto {
    private Long id;
    private Long teacherId;
    private String attendanceStatus;
    private String shift;
    private String attendanceDate;
    private String entryTime;
    private String exitTime;
    private String observations;
}
