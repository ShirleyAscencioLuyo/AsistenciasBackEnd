package pe.edu.vallegrande.AS221S4_T01_be.controller;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Teacher;
import pe.edu.vallegrande.AS221S4_T01_be.service.impl.TeacherServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

	private final TeacherServiceImpl teacherServiceImpl;
	@GetMapping
	public ResponseEntity<List<Teacher>> findAll() {
		return ResponseEntity.ok(teacherServiceImpl.listA());
	}

	@GetMapping("/I")
	public ResponseEntity<List<Teacher>> findAllI() {
		return ResponseEntity.ok(teacherServiceImpl.listI());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Teacher> findTeacher(@PathVariable Long id){
		try {
			Teacher foundTeacher = teacherServiceImpl.findT(id);
			return new ResponseEntity<>(foundTeacher, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Teacher> save(@RequestBody Teacher teacher) {
		Teacher insertedTeacher = teacherServiceImpl.insert(teacher);
		return new ResponseEntity<>(insertedTeacher, HttpStatus.CREATED);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<Teacher> update(@PathVariable Long id, @RequestBody Teacher teacher) {
		try {
			teacher.setId(id);
			Teacher updatedTeacher = teacherServiceImpl.update(teacher);
			return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/active/{id}")
	public ResponseEntity<Optional<Teacher>> active(@PathVariable Long id){
		return ResponseEntity.ok(teacherServiceImpl.active(id));
	}

	@PutMapping("/inactive/{id}")
	public ResponseEntity<Optional<Teacher>> inactive(@PathVariable Long id) {
		return ResponseEntity.ok(teacherServiceImpl.delete(id));
	}

}
