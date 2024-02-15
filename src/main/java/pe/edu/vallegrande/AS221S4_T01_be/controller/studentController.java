package pe.edu.vallegrande.AS221S4_T01_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Student;
import pe.edu.vallegrande.AS221S4_T01_be.service.impl.StudentServiceImpl;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class studentController {

    private final StudentServiceImpl studentServiceImpl;

    //Get
    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok(studentServiceImpl.listA());
    }

    @GetMapping("/I")
    public ResponseEntity<List<Student>> findAllI() {
        return ResponseEntity.ok(studentServiceImpl.listI());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findStudent(@PathVariable Long id) {
        try {
            Student foundStudent = studentServiceImpl.findS(id);
            return new ResponseEntity<>(foundStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //POST
    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student insertedStudent = studentServiceImpl.insertStudent(student);
        return new ResponseEntity<>(insertedStudent, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/edit/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
        try {
            student.setId(id);
            Student updatedStudent = studentServiceImpl.updateStudent(student);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<Optional<Student>> active(@PathVariable Long id) {
        return ResponseEntity.ok(studentServiceImpl.activeStudent(id));
    }

    @PutMapping("/inactive/{id}")
    public ResponseEntity<Optional<Student>> inactive(@PathVariable Long id){
        return ResponseEntity.ok(studentServiceImpl.deleteStudent(id));
    }

    @GetMapping("/{id}/active")
    public ResponseEntity<Student> getActiveStudentById(@PathVariable Long id) {
        try {
            String activeStatus = "A";
            Optional<Student> student = studentServiceImpl.findByIdAndActive(id, activeStatus);
            return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
