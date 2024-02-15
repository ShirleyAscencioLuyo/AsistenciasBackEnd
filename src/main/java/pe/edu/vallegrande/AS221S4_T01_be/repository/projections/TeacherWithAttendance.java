package pe.edu.vallegrande.AS221S4_T01_be.repository.projections;

import java.time.LocalDateTime;

public interface TeacherWithAttendance {
    Long getId();
    Long getTeacherId();
    String getDocumentNumber();
    String getLastname();
    String getName();
    String getTypeCharge();
    String getAttendanceStatus();
    LocalDateTime getEntryTime();
    LocalDateTime getExitTime();
    String getObservations();
}
