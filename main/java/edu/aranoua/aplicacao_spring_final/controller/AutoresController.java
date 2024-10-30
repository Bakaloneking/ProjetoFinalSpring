/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aranoua.aplicacao_spring_final.controller;

import edu.aranoua.aplicacao_spring_final.dto.autores.AutoresOutputDTO;
import edu.aranoua.aplicacao_spring_final.repository.AutoresRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bakal
 */
@RestController
@RequestMapping("/api/autores")
public class AutoresController {
    @Autowired
    AutoresRepository autoresRepository;
    
    @GetMapping
    public ResponseEntity<List<AutoresOutputDTO>>list(){
        List<Autores> autores = autoresRepository.findAll();
    if(autores.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    List<AutoresOutputDTO> autoresDTO = autores.stream();
        .map(AutoresOutputDTO::new)
        .toList();
    return new ResponseEntity<>(AutoresOutputDTO,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AutoresOutputDTO> read(@PathVariable long id){
        Optional<Autores> autores = autoresRepository.findById(id);
        return cidade.map(value -> 
                new ResponseEntity<>(new AutoresOutputDTO(value), HttpStatus.OK)).orElseGet( 
                        -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody AutoresOutputDTO body){
        try{
            AutoresOutputDTO novoAutorDTO = new AutoresOutputDTO(autoresRepository.save(body.build()));
            return new ResponseEntity<>(novoAutorDTO, HttpStatus.CREATED);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getCause(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody AutoresOutputDTO body){
        try {
            Optional<Autores> autores = AutoresRepository.findById(id);
            if(autores.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Autores autoresAntigos = autores.get();
            autoresAntigos.setNome(body.getNome());
            autoresAntigos.setAfiliacao(body.getAfiliacao());
            return new ResponseEntity<>(new AutoresOutputDTO(autoresRepository.save(autoresAntigos)), HttpStatus.OK);    
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try{
            Optional<Autores> autores = autoresRepository.findById(id);
            if(autores.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            autoresRepository.delete(autores.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RuntimeException e){
            return new ResponseEntity<>(e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}