package edu.aranoua.aplicacao_spring_final.dto.artigo;

import edu.aranoua.aplicacao_spring_final.model.Artigo;
import edu.aranoua.aplicacao_spring_final.repository.ArtigoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtigoInputDTO {
    private String titulo;
    private Integer ano;

    public Artigo build(ArtigoRepository artigoRepository){
        Artigo artigo = new artigo();
        artigo.setTitulo(this.titulo);
        artigo.setAno(this.ano);
        return artigo;
    }
}
