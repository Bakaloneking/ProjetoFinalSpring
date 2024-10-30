package edu.aranoua.aplicacao_spring_final.dto.revista;

import edu.aranoua.aplicacao_spring_final.model.Revista;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RevistaOutputDTO {
    private long id;
    private String nome;
    private String issn;

    public RevistaOutputDTO(Revista revista){
        this.id = revista.getId();
        this.nome = revista.getNome();
        this.issn = revista.getIssn();
    }
}
