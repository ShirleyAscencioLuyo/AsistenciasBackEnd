package pe.edu.vallegrande.AS221S4_T01_be.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ASSISTANCE_TEACHER")
public class AssistanceTeacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "attendance_status")
    private String attendanceStatus;

    @Column(name = "shift")
    private String shift;

    @Column(name = "attendance_date")
    private Date attendanceDate;

    @Column(name = "entry_time")
    private LocalDateTime entryTime;

    @Column(name = "exit_time")
    private LocalDateTime exitTime;

    @Column(name = "observations")
    private String observations;

    public AssistanceTeacher(Long id, Teacher teacher, String attendanceStatus, String shift, Date attendanceDate, LocalDateTime entryTime, LocalDateTime exitTime, String observations) {
        this.id = id;
        this.teacher = teacher;
        this.attendanceStatus = attendanceStatus;
        this.shift = shift;
        this.attendanceDate = attendanceDate;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.observations = observations;
    }
}
