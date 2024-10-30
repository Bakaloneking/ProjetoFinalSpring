package edu.aranoua.aplicacao_spring_final.controller;

import edu.aranoua.aplicacao_spring_final.dto.revista.RevistaOutputDTO;
import edu.aranoua.aplicacao_spring_final.service.RevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/revistas")
public class RevistaController {
    @Autowired
    RevistaService revistaService;

    @GetMapping
    public ResponseEntity<List<RevistaOutputDTO>> list() {
        List<RevistaOutputDTO> revista = revistaService.list();
        if (revista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<RevistaOutputDTO> revistaDTO = new ArrayList<>();
        return ResponseEntity.ok(revistaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RevistaOutputDTO> read(@PathVariable long id) {
        List<RevistaOutputDTO> revista = revistaService.list();
        return null;
    }
}
