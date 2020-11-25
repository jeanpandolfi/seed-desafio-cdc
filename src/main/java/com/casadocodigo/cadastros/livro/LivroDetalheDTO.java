package com.casadocodigo.cadastros.livro;

import com.casadocodigo.cadastros.autor.AutorCadastro;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class LivroDetalheDTO {
    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer qntPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private String categoria;
    private AutorCadastro autor;

    public LivroDetalheDTO(Long id, String titulo, String resumo, String sumario, BigDecimal preco, Integer qntPaginas, String isbn, LocalDate dataPublicacao, String categoria, String nomeAutor, String emailAutor, String descricaoAutor) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.qntPaginas = qntPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = new AutorCadastro(nomeAutor, emailAutor, descricaoAutor);
    }
}
