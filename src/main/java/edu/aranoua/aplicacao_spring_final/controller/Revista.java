package edu.aranoua.aplicacao_spring_final.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "revistas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Revista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String issn;

    @OneToMany
    private Autores autores;
    private Artigo artigo;
}