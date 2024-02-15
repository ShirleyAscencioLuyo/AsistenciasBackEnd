package pe.edu.vallegrande.AS221S4_T01_be.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.DocumentType;
import pe.edu.vallegrande.AS221S4_T01_be.repository.DocumentTypeRepository;
import pe.edu.vallegrande.AS221S4_T01_be.service.DocumentTypeService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DocumentTypeServiceImpl implements DocumentTypeService {

    private final DocumentTypeRepository documentTypeRepository;

    public List<DocumentType> getAll() {
        return documentTypeRepository.findAll();
    }


}
