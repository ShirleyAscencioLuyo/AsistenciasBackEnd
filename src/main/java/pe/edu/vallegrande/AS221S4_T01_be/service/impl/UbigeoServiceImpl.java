package pe.edu.vallegrande.AS221S4_T01_be.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.AS221S4_T01_be.model.entity.Ubigeo;
import pe.edu.vallegrande.AS221S4_T01_be.repository.UbigeoRepository;
import pe.edu.vallegrande.AS221S4_T01_be.service.UbigeoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UbigeoServiceImpl implements UbigeoService {

    private final UbigeoRepository ubigeoRepository;

    public List<Ubigeo> getAllUbigeos() {
        return ubigeoRepository.findAll();
    }

}
