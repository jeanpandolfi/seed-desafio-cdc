package com.casadocodigo.cadastros.categoria;

import com.casadocodigo.cadastros.autor.Autor;
import com.casadocodigo.cadastros.autor.AutorCadastro;
import com.casadocodigo.cadastros.validator.UniqueValue;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

/**
 * Classe que expõe a API para o client
 * @cargaIntrinseca 2 */
@Getter
public class CategoriaCadastro {

    @NotBlank
    /** @cargaIntrinseca 1 */
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    /**
     * Método converte um {@link CategoriaCadastro} em um {@link Categoria}
     * @return uma nova instância de {@link Categoria} com base nos atributos deste objeto
     * @cargaIntrinseca 1 */
    public Object toModel() {
        return new Categoria(this.nome);
    }

}
