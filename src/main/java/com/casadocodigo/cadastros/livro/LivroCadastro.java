package com.casadocodigo.cadastros.livro;

import com.casadocodigo.cadastros.autor.Autor;
import com.casadocodigo.cadastros.categoria.Categoria;
import com.casadocodigo.cadastros.validator.ExistsId;
import com.casadocodigo.cadastros.validator.UniqueValue;
import lombok.Getter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

/** @cargaIntrinseca 3 */
@Getter
public class LivroCadastro {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Size(max = 65000)
    private String sumario;

    @NotNull
    @Positive
    @DecimalMin(value = "20.00", inclusive = false)
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer qntPaginas;

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    private LocalDate dataPublicacao;

    @NotNull
    @Positive
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    @NotNull
    @Positive
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;

    /** @cargaIntrinseca 1 */
    public Livro toModel() {
        /** @cargaIntrinseca 1 */
        Categoria categoria = new Categoria();
        categoria.setId(this.categoriaId);
        /** @cargaIntrinseca 1 */
        Autor autor = new Autor();
        autor.setId(this.autorId);
        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.qntPaginas, this.isbn,
                this.dataPublicacao, categoria, autor);
    }
}
