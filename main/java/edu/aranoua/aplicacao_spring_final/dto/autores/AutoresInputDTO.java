/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.aranoua.aplicacao_spring_final.dto.autores;

import edu.aranoua.aplicacao_spring_final.model.Autores;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author bakal
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutoresInputDTO {
    private String nome;
    private String afiliacao;
    
    public Autores build(){
        Autores autores = new Autores();
        autores.setNome(this.nome);
        autores.setAfiliacao(this.afiliacao);
        return autores;
    }
}
