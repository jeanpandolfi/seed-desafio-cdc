package com.casadocodigo.cadastros.categoria;

import com.casadocodigo.cadastros.error.RegraDeNegocioException;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

@Getter
public class CategoriaCadastro {

    @NotBlank
    private String nome;

    public Object toModel() {
        return new Categoria(this.nome);
    }

    public void verificaNomeUnico(EntityManager entityManager) {
        Long id = entityManager.createQuery("select c.id from Categoria c where c.nome = :nome", Long.class)
                .setParameter("nome", this.nome).getSingleResult();

        if(id != null){
            throw new RegraDeNegocioException("O nome já existe");
        }
    }
}
