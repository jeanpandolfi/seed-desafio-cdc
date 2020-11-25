package com.casadocodigo.cadastros.estados;

import com.casadocodigo.cadastros.pais.Pais;
import org.springframework.http.ResponseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** @cargaIntrinseca 1 */
@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne //1
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public Estado(@NotBlank String nome, @NotNull Long idPais) {
        this.nome = nome;
        this.pais = new Pais(idPais);
    }
}
