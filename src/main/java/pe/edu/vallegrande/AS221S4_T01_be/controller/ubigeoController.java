package pe.edu.vallegrande.AS221S4_T01_be.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Ubigeo;
import pe.edu.vallegrande.AS221S4_T01_be.service.impl.UbigeoServiceImpl;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ubigeo")
public class ubigeoController {

    private final UbigeoServiceImpl ubigeoService;

    @GetMapping
    public ResponseEntity<List<Ubigeo>> getAllUbigeos() {
        List<Ubigeo> ubigeos = ubigeoService.getAllUbigeos();
        return ResponseEntity.ok(ubigeos);
    }
}
