package pe.edu.vallegrande.AS221S4_T01_be.service;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    public Teacher insert(Teacher teacher);

    public List<Teacher> listA();

    public List<Teacher> listI();

    public Teacher findT(Long id) throws Exception;

    public Teacher update(Teacher teacher) throws Exception;

    public Optional<Teacher> delete(Long id);

    public Optional<Teacher> active(Long id);

    boolean isTeacherActive(Long teacherId);

}

