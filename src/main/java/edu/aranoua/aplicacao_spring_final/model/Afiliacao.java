package edu.aranoua.aplicacao_spring_final.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "afiliação")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Afiliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private String sigla;
    private String referencia;

    @ManyToOne
    private Autores autores;
}
