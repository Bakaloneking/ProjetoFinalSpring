package edu.aranoua.aplicacao_spring_final.repository;

import edu.aranoua.aplicacao_spring_final.model.Afiliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacaoRepository extends JpaRepository<Afiliacao, String> {
    Afiliacao findByNome(String nome);
}
