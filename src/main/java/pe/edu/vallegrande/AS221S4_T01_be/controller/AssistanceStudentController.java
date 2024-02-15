package pe.edu.vallegrande.AS221S4_T01_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceStudent;
import pe.edu.vallegrande.AS221S4_T01_be.service.impl.AssistanceStudentServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/assistanceS")
@RequiredArgsConstructor
public class AssistanceStudentController {

    private final AssistanceStudentServiceImpl assistanceStudentServiceImpl;

    @GetMapping
    public ResponseEntity<List<AssistanceStudent>> getAll() {
        List<AssistanceStudent> assistanceStudents = assistanceStudentServiceImpl.getAll();
        return ResponseEntity.ok(assistanceStudents);
    }
    @PostMapping
    public ResponseEntity<AssistanceStudent> createAssistance(@RequestBody AssistanceStudent assistanceStudent) {
            AssistanceStudent createdAssistance = assistanceStudentServiceImpl.createAssistance(assistanceStudent);
            return new ResponseEntity<>(createdAssistance, HttpStatus.CREATED);
    }

}
