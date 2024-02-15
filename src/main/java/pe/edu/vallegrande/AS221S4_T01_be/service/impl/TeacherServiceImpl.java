package pe.edu.vallegrande.AS221S4_T01_be.service.impl;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Teacher;
import pe.edu.vallegrande.AS221S4_T01_be.repository.TeacherRepository;
import pe.edu.vallegrande.AS221S4_T01_be.service.TeacherService;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

	private final TeacherRepository teacherRepository;

	@Override
	public Teacher insert(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> listA() {
		return teacherRepository.findAllByActive("A");
	}

	@Override
	public List<Teacher> listI() {
		return teacherRepository.findAllByActive("I");
	}

	@Override
	public Teacher findT(Long id) throws Exception {
		return teacherRepository.findById(id).orElseThrow(
				() -> new Exception("No se encontro la identidad"));
	}

	@Override
	public Teacher update(Teacher teacher) throws Exception {
		findT(teacher.getId());
		return teacherRepository.save(teacher);
	}

	@Override
	@Transactional
	public Optional<Teacher> delete(Long id) {
		teacherRepository.inactiveTeacher(id);
		return teacherRepository.findById(id);
	}

	@Override
	@Transactional
	public Optional<Teacher> active(Long id) {
		teacherRepository.activeTeacher(id);
		return teacherRepository.findById(id);
	}

	@Override
	public boolean isTeacherActive(Long teacherId) {
		Optional<Teacher> teacherOptional = teacherRepository.findByIdAndActive(teacherId, "A");
		return teacherOptional.isPresent();
	}

}