package edu.aranoua.aplicacao_spring_final.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "artigos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Artigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private Integer ano;

    @OneToMany
    private Autores autores;
    @ManyToOne
    private Revista revista;
}

