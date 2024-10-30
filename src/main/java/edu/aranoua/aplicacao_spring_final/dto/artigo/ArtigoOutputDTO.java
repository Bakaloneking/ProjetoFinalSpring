package edu.aranoua.aplicacao_spring_final.dto.artigo;

import edu.aranoua.aplicacao_spring_final.model.Artigo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtigoOutputDTO {
    private long id;
    private String titulo;
    private Integer ano;

    public ArtigoOutputDTO(Artigo artigo){
        this.id = artigo.getId();
        this.titulo = artigo.getNome();
        this.ano = artigo.getIssn();
    }
}
