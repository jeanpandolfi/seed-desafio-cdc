package com.casadocodigo.cadastros.fluxopagamento;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

/** @cargaIntrinseca 1*/
@RequiredArgsConstructor
@RestController
@RequestMapping("/fluxo-pagamento")
public class FluxoPagamentoController {

    private final EntityManager manager;

    @PostMapping                                                    //1
    public ResponseEntity<Void> cadastrosCliente(@RequestBody @Valid ClienteCadastro clienteCadastro){
        return ResponseEntity.ok().build();
    }
}
