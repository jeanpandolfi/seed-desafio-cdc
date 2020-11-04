package com.casadocodigo.cadastros.autor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    private final AutorRopository autorRopository;

    @PostMapping
    public ResponseEntity<Autor> cadastrar(@Valid @RequestBody AutorCadastro autorCadastro){
        this.autorRopository.save(autorCadastro.toEntity());
        return ResponseEntity.ok().build();
    }

}
