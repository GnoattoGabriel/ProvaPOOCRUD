package com.gnoatto.school.services;


import com.gnoatto.school.models.EstudanteModel;
import com.gnoatto.school.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public EstudanteModel criarEstudante(EstudanteModel EstudanteModel){
        return estudanteRepository.save(EstudanteModel);
    }

    public List<EstudanteModel> findAll(){
        return estudanteRepository.findAll();
    }

    public void deletarAluno(Long id){
        estudanteRepository.deleteById(id);
    }

}
