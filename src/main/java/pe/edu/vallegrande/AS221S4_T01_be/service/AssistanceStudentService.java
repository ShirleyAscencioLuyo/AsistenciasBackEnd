package pe.edu.vallegrande.AS221S4_T01_be.service;


import pe.edu.vallegrande.AS221S4_T01_be.model.entity.AssistanceStudent;

import java.util.List;

public interface AssistanceStudentService {

    List<AssistanceStudent> getAll();

    AssistanceStudent createAssistance(AssistanceStudent assistanceStudent);

}
