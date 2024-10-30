package edu.aranoua.aplicacao_spring_final.dto.revista;

import edu.aranoua.aplicacao_spring_final.model.Revista;
import edu.aranoua.aplicacao_spring_final.repository.RevistaRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RevistaInputDTO {
    private String nome;
    private String issn;

    public Revista build(RevistaRepository revistaRepository){
        Revista revistas = new Revista();
        revistas.setNome(this.nome);
        revistas.setIssn(this.issn);
        return revistas;
    }
}
