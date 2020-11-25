package com.casadocodigo.cadastros.livro;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

/** @cargaIntrinseca 1 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/livros")
public class LivroController {

    private final EntityManager entityManager;

    @Transactional
    @PostMapping                                         /** @cargaIntrinseca 1 */
    public ResponseEntity<Void> cadastar(@Valid @RequestBody LivroCadastro livroCadastro){
        entityManager.persist(livroCadastro.toModel());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LivroListagemDTO>> listar(){
        String query = "select new com.casadocodigo.cadastros.livro.LivroListagemDTO(l.id, l.titulo) from Livro l";
        return ResponseEntity.ok(entityManager.createQuery(query, LivroListagemDTO.class).getResultList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalheDTO> obterPorId(@PathVariable("id") Long id){
        String query = "select " +
                "new com.casadocodigo.cadastros.livro.LivroDetalheDTO(l.id, l.titulo, l.resumo, l.sumario, l.preco, l.qntPaginas, l.isbn, l.dataPublicacao, l.categoria.nome, " +
                "l.autor.nome, l.autor.email, l.autor.descricao) from Livro l where l.id = :id";
        return ResponseEntity.ok(entityManager.createQuery(query, LivroDetalheDTO.class).setParameter("id", id).getSingleResult());
    }
}