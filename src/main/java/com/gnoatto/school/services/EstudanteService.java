package com.gnoatto.school.services;


import com.gnoatto.school.models.EstudanteModel;
import com.gnoatto.school.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel){
        return estudanteRepository.save(estudanteModel);
    }

    public List<EstudanteModel> findAll(){
        return estudanteRepository.findAll();
    }

    public void deletarAluno(Long id){
        estudanteRepository.deleteById(id);
    }

    public EstudanteModel buscarPorID(Long id){
        return estudanteRepository.findById(id).get();
    }

    public EstudanteModel atualizar(Long id, EstudanteModel estudanteModel){

        EstudanteModel model = estudanteRepository.findById(id).get();
        model.setNome(estudanteModel.getNome());


        return estudanteRepository.save(estudanteModel);
    }

}
