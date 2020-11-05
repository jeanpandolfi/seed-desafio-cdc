package com.casadocodigo.cadastros.autor;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Classe que expõe a API para o client */
@Getter
public class AutorCadastro {

    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotBlank
    @Size(min = 2, max = 400)
    private String descricao;

    /**
     * Método converte um {@link AutorCadastro} em um {@link Autor}
     * @return uma nova instância de {@link Autor} com base nos atributos deste
     * objeto setando a dataRegistro de agora.
     * */
    public Autor toEntity(){
        return new Autor(this.nome, this.email, this.descricao);
    }
}
