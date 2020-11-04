package com.casadocodigo.cadastros.autor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String nome;

    @Column( nullable = false)
    private String email;

    @Column( nullable = false, length = 400)
    private String descricao;

    @Column( nullable = false)
    private LocalDateTime dataRegistro;

    public Autor(String nome, String email, String descricao, LocalDateTime dataRegistro) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataRegistro = dataRegistro;
    }
}
