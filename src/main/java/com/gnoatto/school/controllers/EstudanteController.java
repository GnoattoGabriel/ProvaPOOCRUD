package com.gnoatto.school.controllers;


import com.gnoatto.school.models.EstudanteModel;
import com.gnoatto.school.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping
    public ResponseEntity<EstudanteModel> criarAluno(@RequestBody EstudanteModel estudanteModel){
        EstudanteModel novo = estudanteService.criarEstudante(estudanteModel);
        return ResponseEntity.status(201).body(novo);
    }

    @GetMapping
    public List<EstudanteModel> buscarTodosEstudantes() {
        return estudanteService.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEstudante(@PathVariable Long id){
        estudanteService.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudanteModel> buscarPorId(@PathVariable Long id){
        Optional<EstudanteModel> estudante = estudanteService.buscarPorID(id);

        if(estudante.isPresent()){
            return ResponseEntity.ok(estudante.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public EstudanteModel atualizar(@PathVariable Long id,@RequestBody EstudanteModel estudanteModel){
        estudanteModel.setId(id);
        return estudanteService.atualizar(id, estudanteModel);
    }
}
