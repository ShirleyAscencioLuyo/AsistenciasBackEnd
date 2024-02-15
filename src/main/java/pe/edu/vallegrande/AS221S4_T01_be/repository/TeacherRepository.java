package pe.edu.vallegrande.AS221S4_T01_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Teacher;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

    List<Teacher> findAllByActive(String active);

    Optional<Teacher> findByIdAndActive(Long id, String active);

    @Modifying
    @Query(value = "update Teacher t set t.active = 'I' where t.id = ?1")
    void inactiveTeacher(Long id);

    @Modifying
    @Query(value = "update Teacher t set t.active = 'A' where t.id = ?1")
    void activeTeacher(Long id);

}
