package pe.edu.vallegrande.AS221S4_T01_be.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Student;
import pe.edu.vallegrande.AS221S4_T01_be.repository.StudentRepository;
import pe.edu.vallegrande.AS221S4_T01_be.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> listA() {
        return studentRepository.findAllByActive("A");
    }

    @Override
    public List<Student> listI() {
        return studentRepository.findAllByActive("I");
    }

    @Override
    public Student findS(Long id) throws Exception {
        return studentRepository.findById(id).orElseThrow(
                () -> new Exception("No se encontro la identidad"));
    }

    @Override
    public Student updateStudent(Student student) throws Exception {
        findS(student.getId());
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Optional<Student> deleteStudent(Long id) {
        studentRepository.inactiveStudent(id);
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Student> activeStudent(Long id) {
        studentRepository.activeStudent(id);
        return studentRepository.findById(id);
    }

    @Override
    public Optional<Student> findByIdAndActive(Long id, String active) {
        return studentRepository.findByIdAndActive(id, active);
    }

    @Override
    public boolean isStudentActive(Long id) {
        Optional<Student> studentOptional = studentRepository.findByIdAndActive(id, "A");
        return studentOptional.isPresent();
    }

}