package com.prjestudantes.estudantes.controller;

import com.prjestudantes.estudantes.repository.EstudantesRepository;

import java.util.List;
import java.util.Optional;

import com.prjestudantes.estudantes.entities.Estudantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/estudantes")        
@CrossOrigin
public class EstudantesController {
    @Autowired
    private EstudantesRepository repo;

    @GetMapping
    public List<Estudantes> getEstudantes() {
        List<Estudantes> lista = repo.findAll();
        return lista;
    }

    
    @GetMapping("{id}")
    public Estudantes getEstudante(@PathVariable Long id){
        Optional<Estudantes> op =  repo.findById(id);
        Estudantes estudantes = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return estudantes;
    }


    @PostMapping
    public Estudantes salvar(@RequestBody Estudantes estudantes){
        estudantes = repo.save(estudantes);
        return estudantes;
    }

    @PutMapping("{id}")
    public Estudantes alterar(@RequestBody Estudantes updateEstudantes, @PathVariable Long id){
        Optional<Estudantes> op =  repo.findById(id);
        Estudantes estudantes = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        estudantes.setName(updateEstudantes.getName());
        repo.save(estudantes);
        return estudantes;
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable Long id){
        Optional<Estudantes> op =  repo.findById(id);
        Estudantes estudantes = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        repo.delete(estudantes);
    }

}
