package com.casadocodigo.cadastros.autor;

import com.casadocodigo.cadastros.validator.UniqueValue;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Classe que expõe a API para o client
 * @cargaIntrinseca 2 */
@Getter
public class AutorCadastro {

    @NotBlank
    private String nome;

    @Email
    /** @cargaIntrinseca 1 */
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(min = 2, max = 400)
    private String descricao;

    /**
     * Método converte um {@link AutorCadastro} em um {@link Autor}
     * @return uma nova instância de {@link Autor} com base nos atributos deste
     * objeto setando a dataRegistro de agora.
     * @cargaIntrinseca 1 */
    public Autor toEntity(){
        return new Autor(this.nome, this.email, this.descricao);
    }

}
