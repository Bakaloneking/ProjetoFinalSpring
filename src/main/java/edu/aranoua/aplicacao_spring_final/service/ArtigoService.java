package edu.aranoua.aplicacao_spring_final.service;

import edu.aranoua.aplicacao_spring_final.dto.artigo.ArtigoInputDTO;
import edu.aranoua.aplicacao_spring_final.dto.artigo.ArtigoOutputDTO;
import edu.aranoua.aplicacao_spring_final.model.Artigo;
import edu.aranoua.aplicacao_spring_final.repository.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtigoService {
    @Autowired
    ArtigoRepository artigoRepository;
    private List<ArtigoOutputDTO> artigoOutputDTO;
    public List<ArtigoOutputDTO> list(){
        List<Artigo> artigo = artigoRepository.findAll();
        return artigoOutputDTO;
    }
    ArtigoInputDTO read(long id){
        Optional<Artigo> artigo = artigoRepository.findById(id);
        if(artigo.isPresent()){
            return new ArtigoOutputDTO(artigo.get());
        }
        return (ArtigoInputDTO) artigoOutputDTO;
    }
    public ArtigoOutputDTO create(ArtigoInputDTO artigoInputDTO){
        try{
            Artigo artigo = artigoInputDTO.build(artigoRepository);
            ArtigoOutputDTO artigoOutputDTO = new ArtigoOutputDTO(artigo);
            return artigoOutputDTO;
        } catch (Exception e){
            return null;
        }

    }
}
