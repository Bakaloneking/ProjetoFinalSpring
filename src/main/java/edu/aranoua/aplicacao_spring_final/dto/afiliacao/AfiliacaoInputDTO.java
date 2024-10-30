package edu.aranoua.aplicacao_spring_final.dto.afiliacao;

import edu.aranoua.aplicacao_spring_final.model.Afiliacao;
import edu.aranoua.aplicacao_spring_final.repository.AfiliacaoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AfiliacaoInputDTO {
    private String nome;
    private String sigla;
    private String referencia;

    public Afiliacao build(AfiliacaoRepository afiliacaoRepository) {
        Afiliacao afiliacao = new Afiliacao();
        afiliacao.setNome(this.nome);
        afiliacao.setSigla(this.sigla);
        afiliacao.setReferencia(this.referencia);
        return afiliacao;
    }
}
