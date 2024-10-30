package edu.aranoua.aplicacao_spring_final.repository;

import edu.aranoua.aplicacao_spring_final.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bakal
 */
@Repository
public interface AutoresRepository extends JpaRepository<Autores, Long>{
    Autores findByNome(String nome);
}