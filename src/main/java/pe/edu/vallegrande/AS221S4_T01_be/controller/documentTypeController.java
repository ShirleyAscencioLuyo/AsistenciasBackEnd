package pe.edu.vallegrande.AS221S4_T01_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.DocumentType;
import pe.edu.vallegrande.AS221S4_T01_be.service.impl.DocumentTypeServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/document")
public class documentTypeController {

    private final DocumentTypeServiceImpl documentTypeService;

    @GetMapping
    public ResponseEntity<List<DocumentType>> getAll() {
        List<DocumentType> documentTypes = documentTypeService.getAll();
        return ResponseEntity.ok(documentTypes);
    }
}
