package edu.aranoua.aplicacao_spring_final.controller;

import edu.aranoua.aplicacao_spring_final.dto.artigo.ArtigoOutputDTO;
import edu.aranoua.aplicacao_spring_final.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/artigo")
public class ArtigoController {
    @Autowired
    ArtigoService artigoService;

    @GetMapping
    public ResponseEntity<List<ArtigoOutputDTO>> list() {
        List<ArtigoOutputDTO> artigo = artigoService.list();
        if (artigo.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<ArtigoOutputDTO> artigoDTO = new ArrayList<>();
        return ResponseEntity.ok(artigoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtigoOutputDTO> read(@PathVariable long id) {
        List<ArtigoOutputDTO> artigo = artigoService.list();
        return null;
    }
}
