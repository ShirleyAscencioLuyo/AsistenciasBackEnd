package pe.edu.vallegrande.AS221S4_T01_be.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "cellphone")
    private String cellphone;

    @Column(name = "email")
    private String email;

    @ManyToOne()
    @JoinColumn (name = "document_type_id")
    private DocumentType documentType;

    @Column(name = "document_number")
    private String documentNumber;

    @ManyToOne()
    @JoinColumn (name = "ubigeo_id")
    private Ubigeo ubigeo;

    @Column(name = "section")
    private String section;

    @Column(name = "grade")
    private Integer grade;

    @Column(name = "active")
    private  String active;

    @PrePersist
    public void prePersist() {
        if (this.name != null) {
            this.name = this.name.toUpperCase();
        }

        if (this.lastname != null) {
            this.lastname = this.lastname.toUpperCase();
        }
    }
}
