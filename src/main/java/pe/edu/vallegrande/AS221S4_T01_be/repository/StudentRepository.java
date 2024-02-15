package pe.edu.vallegrande.AS221S4_T01_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByActive(String active);

    Optional<Student> findByIdAndActive(Long id, String active);

    @Modifying
    @Query(value = "update Student s set s.active = 'I' where s.id = ?1")
    void inactiveStudent(Long id);

    @Modifying
    @Query(value = "update Student s set s.active = 'A' where s.id = ?1")
    void activeStudent(Long id);


}
