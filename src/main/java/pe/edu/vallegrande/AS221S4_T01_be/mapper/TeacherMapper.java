package pe.edu.vallegrande.AS221S4_T01_be.mapper;

import org.springframework.stereotype.Service;

import pe.edu.vallegrande.AS221S4_T01_be.model.dto.TeacherResponseDto;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Teacher;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Optional;

@Service
public class TeacherMapper {

    public TeacherResponseDto toDto(Teacher teacher) {
        return new TeacherResponseDto(
                teacher.getDocumentType().getNameDocument(),
                teacher.getDocumentNumber(),
                teacher.getName(),
                teacher.getLastname(),
                Optional.ofNullable(teacher.getCellphone()).orElse(""),
                Optional.ofNullable(teacher.getEmail()).orElse(""),
                teacher.getBirthdate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)),
                teacher.getUbigeo().getDepartment() + " - " + teacher.getUbigeo().getProvince() + " - " + teacher.getUbigeo().getDistrict(),
                teacher.getTypeCharge(),
                teacher.getTypeCondition(),
                teacher.getWorkday()
        );
    }
}
