package com.casadocodigo.cadastros.livro;

import com.casadocodigo.cadastros.autor.Autor;
import com.casadocodigo.cadastros.categoria.Categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

/** @cargaIntrinseca 2 */
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String titulo;

    @Column(length = 500, nullable = false)
    private String resumo;

    @Column(length = 50000)
    private String sumario;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Integer qntPaginas;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    //
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    //1
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @Size(max = 65000) String sumario, @NotEmpty @Positive @DecimalMin(value = "20.00", inclusive = false) BigDecimal preco, @NotEmpty @Min(value = 100) Integer qntPaginas, @NotBlank String isbn, @NotNull @Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.qntPaginas = qntPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }
}
