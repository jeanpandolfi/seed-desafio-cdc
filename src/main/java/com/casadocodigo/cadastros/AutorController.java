package com.casadocodigo.cadastros;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/autores")
public class AutorController {

    private final AutorRopository autorRopository;

    @PostMapping
    public ResponseEntity<Autor> cadastrar(@RequestBody Autor autor){
        autor.setDataRegistro(LocalDateTime.now());
        return ResponseEntity.ok(this.autorRopository.save(autor));
    }

}
