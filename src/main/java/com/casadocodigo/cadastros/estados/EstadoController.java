package com.casadocodigo.cadastros.estados;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estados")
public class EstadoController {

    private final EntityManager manager;

    @Transactional
    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid EstadoCadastro estadoCadastro){
       manager.persist(estadoCadastro.toModel());
       return ResponseEntity.ok().build();
    }
}
