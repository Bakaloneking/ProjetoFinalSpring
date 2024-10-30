package edu.aranoua.aplicacao_spring_final.controller;

import edu.aranoua.aplicacao_spring_final.dto.autores.AutoresInputDTO;
import edu.aranoua.aplicacao_spring_final.dto.autores.AutoresOutputDTO;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import edu.aranoua.aplicacao_spring_final.service.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;

/**
 *
 * @author bakal
 */
@RestController
@RequestMapping("/api/autores")
public class AutoresController {
    @Autowired
    AutoresService autoresService;

    @GetMapping
    public ResponseEntity<List<AutoresOutputDTO>> list() {
        List<AutoresOutputDTO> autores = autoresService.list();
        if (autores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<AutoresOutputDTO> autoresDTO = new ArrayList<>();
        return ResponseEntity.ok(autoresDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoresOutputDTO> read(@PathVariable long id) {
        List<AutoresOutputDTO> autores = autoresService.list();
        return null;
    }

    /*@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AutoresOutputDTO> create(@RequestBody AutoresInputDTO autoresInputDTO, UriComponents uriBuilder) {
        AutoresOutputDTO autoresOutputDTO = autoresService.create(autoresInputDTO);
        if (autoresOutputDTO != null) {
            UriComponents uriComponents = uriBuilder.path("/api/autores/{id}").buildAndExpand(autoresOutputDTO.getId());
            URI uri = uriComponents.toUri();
            return ResponseEntity.created(uri).contentType(MediaType.APPLICATION_JSON).body(autoresOutputDTO);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }*/
/*
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
*/}
