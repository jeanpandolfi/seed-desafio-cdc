package com.casadocodigo.cadastros.livro;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Classe que expoõe a APi representando uma lisategem de livros.
 * @cargaIntrinseca 0 */
@AllArgsConstructor
@Getter
public class LivroListagemDTO{
    private Long id;
    private String nome;
}
