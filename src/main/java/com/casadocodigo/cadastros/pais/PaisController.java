package com.casadocodigo.cadastros.pais;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import java.util.List;

/** @cargaIntrinseca 1 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/paises")
public class PaisController {

    private final EntityManager manager;

    @Transactional
    @PostMapping("/{nomePais}")
    ResponseEntity<Void> cadastrar(@PathVariable("nomePais") @NotBlank String nomePais){
        List<Long> ids = manager.createQuery("select p.id from Pais p where p.nome = :nome", Long.class).setParameter("nome", nomePais).getResultList();
        if(!ids.isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe o país cadastrado");
        //TODO não está funcinando. Ocorre erro de transação
        //1
        Pais pais = new Pais(nomePais);
        manager.persist(pais);
        return ResponseEntity.ok().build();
    }


}
