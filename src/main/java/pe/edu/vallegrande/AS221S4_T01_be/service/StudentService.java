package pe.edu.vallegrande.AS221S4_T01_be.service;

import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public Student insertStudent(Student student);

    public List<Student> listA();

    public List<Student> listI();

    public Student findS(Long id) throws Exception;

    public Student updateStudent(Student student) throws Exception;

    public Optional<Student> deleteStudent(Long id);

    public Optional<Student> activeStudent(Long id);

    Optional<Student> findByIdAndActive(Long id, String active);

    boolean isStudentActive(Long studentId);


}
