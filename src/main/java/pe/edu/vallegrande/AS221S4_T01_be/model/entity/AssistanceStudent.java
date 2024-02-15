package pe.edu.vallegrande.AS221S4_T01_be.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ASSISTANCE_STUDENT")
public class AssistanceStudent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "student_id")
    private Student student;

    @CreationTimestamp
    @Column(name = "input")
    private LocalDateTime input;

    @Column(name = "grade_section")
    private String gradeSection;

    @Column(name = "states")
    private String states;

    @Column(name = "shifts")
    private String shifts;

    @Column(name = "Observation")
    private String observation;

}
