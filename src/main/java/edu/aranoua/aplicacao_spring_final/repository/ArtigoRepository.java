package edu.aranoua.aplicacao_spring_final.repository;

import edu.aranoua.aplicacao_spring_final.model.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtigoRepository extends JpaRepository<Artigo, long> {
    Artigo findByNome(String nome);

}
