package pe.edu.vallegrande.AS221S4_T01_be.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T01_be.model.dto.AssistanceTeacherDto;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceTeacher;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Teacher;
import pe.edu.vallegrande.AS221S4_T01_be.repository.TeacherRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AssistanceTeacherMapper {

    private final TeacherRepository teacherRepository;

    public List<AssistanceTeacher> toEntity(List<AssistanceTeacherDto> assistanceTeacherDtos) {
        return assistanceTeacherDtos.stream()
                .filter(assistanceTeacherDto -> Objects.nonNull(assistanceTeacherDto.getAttendanceStatus()))
                .map(assistanceTeacherDto -> {
                    Teacher teacher = teacherRepository.findById(assistanceTeacherDto.getTeacherId()).get();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                    Date date = null;
                    try {
                        date = formatter.parse(assistanceTeacherDto.getAttendanceDate());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                    return new AssistanceTeacher(
                            assistanceTeacherDto.getId(),
                            teacher,
                            assistanceTeacherDto.getAttendanceStatus(),
                            assistanceTeacherDto.getShift(),
                            date,
                            Optional.ofNullable(assistanceTeacherDto.getEntryTime()).map(entryTime -> LocalDateTime.parse(entryTime, formatter2)).orElse(null),
                            Optional.ofNullable(assistanceTeacherDto.getExitTime()).map(exitTime -> LocalDateTime.parse(exitTime, formatter2)).orElse(null),
                            assistanceTeacherDto.getObservations()
                    );
                }).collect(Collectors.toList());
    }
}
