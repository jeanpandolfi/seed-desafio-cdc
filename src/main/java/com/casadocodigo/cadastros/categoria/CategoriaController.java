package com.casadocodigo.cadastros.categoria;

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
@RequestMapping(path = "/categorias")
public class CategoriaController {

    private final EntityManager entityManager;

    @Transactional
    @PostMapping
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody CategoriaCadastro categoriaCadastro){
        categoriaCadastro.verificaNomeUnico(entityManager);
        this.entityManager.persist(categoriaCadastro.toModel());
        return ResponseEntity.ok().build();
    }
}
