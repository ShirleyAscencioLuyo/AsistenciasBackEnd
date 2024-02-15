package pe.edu.vallegrande.AS221S4_T01_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceStudent;

public interface AssistanceStudentRepository extends JpaRepository<AssistanceStudent, Long> {
}
