package edu.aranoua.aplicacao_spring_final.repository;

import edu.aranoua.aplicacao_spring_final.model.Revista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevistaRepository extends JpaRepository<Revista, long> {
    Revista findByNome(String nome);
}
