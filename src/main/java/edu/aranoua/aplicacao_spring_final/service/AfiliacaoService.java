package edu.aranoua.aplicacao_spring_final.service;

import edu.aranoua.aplicacao_spring_final.dto.afiliacao.AfiliacaoInputDTO;
import edu.aranoua.aplicacao_spring_final.dto.afiliacao.AfiliacaoOutputDTO;
import edu.aranoua.aplicacao_spring_final.model.Afiliacao;
import edu.aranoua.aplicacao_spring_final.repository.AfiliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliacaoService {
    @Autowired
    AfiliacaoRepository afiliacaoRepository;
    private List<AfiliacaoOutputDTO> afiliacaoOutputDTO;
    public List<AfiliacaoOutputDTO> list(){
        List<Afiliacao> afiliacao = afiliacaoRepository.findAll();
        return afiliacaoOutputDTO;
    }
    AfiliacaoOutputDTO read(String nome){
        Optional<Afiliacao> afiliacao = Optional.ofNullable(afiliacaoRepository.findByNome(nome));
        if (afiliacao.isPresent()){
            return new AfiliacaoOutputDTO(afiliacao.get());
        }
        return (AfiliacaoOutputDTO) afiliacaoOutputDTO;
    }
    public AfiliacaoOutputDTO create(AfiliacaoInputDTO afiliacaoInputDTO){
        try {
            Afiliacao afiliacao = afiliacaoInputDTO.build(afiliacaoRepository);
            AfiliacaoOutputDTO afiliacaoOutputDTO = new AfiliacaoOutputDTO(afiliacao);
            return afiliacaoOutputDTO;
        } catch (Exception e){
            return null;
        }
    }
}
