package edu.aranoua.aplicacao_spring_final.service;

import edu.aranoua.aplicacao_spring_final.dto.autores.AutoresInputDTO;
import edu.aranoua.aplicacao_spring_final.dto.autores.AutoresOutputDTO;
import edu.aranoua.aplicacao_spring_final.model.Autores;
import edu.aranoua.aplicacao_spring_final.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresService {
    @Autowired
    AutoresRepository autoresRepository;
    private List<AutoresOutputDTO> autoresOutputDTO;
    public List<AutoresOutputDTO> list(){
        List<Autores> autores = autoresRepository.findAll();
        return autoresOutputDTO;
    }
    AutoresOutputDTO read(long id){
        Optional<Autores> autores = autoresRepository.findById(id);
        if(autores.isPresent()){
            return new AutoresOutputDTO(autores.get());
        }
        return (AutoresOutputDTO) autoresOutputDTO;
    }
    public AutoresOutputDTO create(AutoresInputDTO autoresInputDTO){
        try{
            Autores autores = autoresInputDTO.build(autoresRepository);
            AutoresOutputDTO autoresOutputDTO = new AutoresOutputDTO(autores);
            return autoresOutputDTO;
        } catch (Exception e){
            return null;
        }

    }
}
