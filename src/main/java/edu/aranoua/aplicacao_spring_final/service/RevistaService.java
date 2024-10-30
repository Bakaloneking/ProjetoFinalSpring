package edu.aranoua.aplicacao_spring_final.service;

import edu.aranoua.aplicacao_spring_final.dto.revista.RevistaInputDTO;
import edu.aranoua.aplicacao_spring_final.dto.revista.RevistaOutputDTO;
import edu.aranoua.aplicacao_spring_final.model.Revista;
import edu.aranoua.aplicacao_spring_final.repository.RevistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RevistaService {
    @Autowired
    RevistaRepository revistaRepository;
    private List<RevistaOutputDTO> revistaOutputDTO;
    public List<RevistaOutputDTO> list(){
        List<Revista> revistas = revistaRepository.findAll();
        return revistaOutputDTO;
    }
    RevistaOutputDTO read(long id){
        Optional<Revista> revistas = revistaRepository.findById(id);
        if(revistas.isPresent()){
            return new RevistaOutputDTO(revistas.get());
        }
        return (RevistaOutputDTO) revistaOutputDTO;
    }
    public RevistaOutputDTO create(RevistaInputDTO revistaInputDTO){
        try{
            Revista revistas = revistaInputDTO.build(revistaRepository);
            RevistaOutputDTO revistaOutputDTO = new RevistaOutputDTO(revistas);
            return revistaOutputDTO;
        } catch (Exception e){
            return null;
        }

    }
}
