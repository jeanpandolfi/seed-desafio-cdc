package com.casadocodigo.cadastros.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    public Pais(@NotNull Long idPais) {
        this.id = idPais;
    }
}
