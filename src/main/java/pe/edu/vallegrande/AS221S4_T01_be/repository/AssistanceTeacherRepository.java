package pe.edu.vallegrande.AS221S4_T01_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceTeacher;
import pe.edu.vallegrande.AS221S4_T01_be.repository.projections.TeacherWithAttendance;

import java.util.Date;
import java.util.List;

@Repository
public interface AssistanceTeacherRepository extends JpaRepository<AssistanceTeacher, Long> {

    @Query(value = "SELECT " +
            "   at.id as id, " +
            "   t.id as teacherId, " +
            "   t.documentNumber as documentNumber, " +
            "   t.lastname as lastname, " +
            "   t.name as name, " +
            "   t.typeCharge as typeCharge, " +
            "   at.attendanceStatus as attendanceStatus, " +
            "   at.entryTime as entryTime, " +
            "   at.exitTime as exitTime, " +
            "   at.observations as observations " +
            "FROM Teacher t " +
            "LEFT JOIN t.assistanceTeachers at ON at.shift = :shift AND at.attendanceDate = :attendanceDate " +
            "WHERE t.active = 'A' " +
            "ORDER BY t.lastname ASC")
    List<TeacherWithAttendance> findTeachersWithAttendance(@Param("shift") String shift,
                                                           @Param("attendanceDate") Date attendanceDate);
}
