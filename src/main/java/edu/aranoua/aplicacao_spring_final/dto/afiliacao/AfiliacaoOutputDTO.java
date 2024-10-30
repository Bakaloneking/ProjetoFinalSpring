package edu.aranoua.aplicacao_spring_final.dto.afiliacao;

import edu.aranoua.aplicacao_spring_final.model.Afiliacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AfiliacaoOutputDTO {
    private String nome;
    private String sigla;
    private String referencia;

    public AfiliacaoOutputDTO(Afiliacao afiliacao) {
        this.nome = afiliacao.getNome();
        this.sigla = afiliacao.getSigla();
        this.referencia = afiliacao.getReferencia();
    }
}
