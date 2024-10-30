package edu.aranoua.aplicacao_spring_final.controller;

import edu.aranoua.aplicacao_spring_final.dto.afiliacao.AfiliacaoOutputDTO;
import edu.aranoua.aplicacao_spring_final.service.AfiliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/afiliacoes")
public class AfiliacaoController {
    @Autowired
    AfiliacaoService afiliacaoService;

    @GetMapping
    public ResponseEntity<List<AfiliacaoOutputDTO>> List(){
        List<AfiliacaoOutputDTO> afiliacao = afiliacaoService.list();
        if(afiliacao.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        List<AfiliacaoOutputDTO> afiliacaoDTO = new ArrayList<>();
        return ResponseEntity.ok(afiliacaoDTO);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<AfiliacaoOutputDTO> read(@PathVariable String nome){
        List<AfiliacaoOutputDTO> afiliacao = afiliacaoService.list();
        return null;
    }
}
