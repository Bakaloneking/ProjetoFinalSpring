package edu.aranoua.aplicacao_spring_final.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author bakal
 */
@Entity
@Table(name = "autores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Autores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String afiliacao;

    @ManyToOne
    private Afiliacao afiliacao1;
    private Artigo artigo;

    @OneToMany
    private Revista revista;
}
