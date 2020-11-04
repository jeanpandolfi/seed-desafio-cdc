package com.casadocodigo.cadastros.autor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    private final EntityManager entityManager;

    @Transactional
    @PostMapping
    public ResponseEntity<Autor> cadastrar(@Valid @RequestBody AutorCadastro autorCadastro){
        this.entityManager.persist(autorCadastro.toEntity());
        return ResponseEntity.ok().build();
    }

}
