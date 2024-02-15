package pe.edu.vallegrande.AS221S4_T01_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TeacherResponseDto {

    private String nameDocument;
    private String documentNumber;
    private String name;
    private String lastname;
    private String cellphone;
    private String email;
    private String birthdate;
    private String ubigeo;
    private String typeCharge;
    private String typeCondition;
    private String workday;
}
