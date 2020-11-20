package com.casadocodigo.cadastros.autor;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
/**
 * @cargaIntrinseca 0 */
@NoArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Column( nullable = false)
    private String nome;

    @Column( nullable = false, unique = true)
    private String email;

    @Column( nullable = false, length = 400)
    private String descricao;

    @Column( nullable = false)
    private LocalDateTime dataRegistro;

    /**
     * @param nome indica o nome do Autor
     * @param email indica o email do Autor
     * @param descricao indica a descricao do Autor
     * @return objeto Autor com os atributos naturais passados
     * */
    public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataRegistro = LocalDateTime.now();
    }
}
