package pe.edu.vallegrande.AS221S4_T01_be.model.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TEACHER")
public class Teacher implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne()
	@JoinColumn (name = "document_type_id")
	private DocumentType documentType;

	@Column(name = "document_number")
	private String documentNumber;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "cellphone")
	private String cellphone;

	@Column(name = "email")
	private String email;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@ManyToOne()
	@JoinColumn (name = "ubigeo_id")
	private Ubigeo ubigeo;

	@Column(name = "type_charge")
	private String typeCharge;

	@Column(name = "type_condition")
	private String typeCondition;

	@Column(name = "workday")
	private String workday;

	@Column(name = "active")
	private String active;

	@JsonIgnore
	@OneToMany(mappedBy = "teacher")
	private List<AssistanceTeacher> assistanceTeachers;

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
