package pe.edu.vallegrande.AS221S4_T01_be.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.DocumentType;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Ubigeo;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentDto {
    private String name;
    private String lastname;
    private LocalDate birthdate;
    private String cellphone;
    private String email;
    private DocumentType documentType;
    private String documentNumber;
    private Ubigeo ubigeo;

}
