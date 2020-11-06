package com.casadocodigo.cadastros.autor;

import com.casadocodigo.cadastros.autor.error.AutorException;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Classe que expõe a API para o client
 * @cargaIntrinseca 1 */
@Getter
public class AutorCadastro {

    @NotBlank
    private String nome;

    @Email
    private String email;

    @NotBlank
    @Size(min = 2, max = 400)
    private String descricao;

    /**
     * Método converte um {@link AutorCadastro} em um {@link Autor}
     * @return uma nova instância de {@link Autor} com base nos atributos deste
     * objeto setando a dataRegistro de agora.
     * */
    public Autor toEntity(){
        return new Autor(this.nome, this.email, this.descricao);
    }

    public void verificaEmailUnico(EntityManager entityManager) {
        Long autorId = entityManager.createQuery("select a.id from Autor a where a.email = :email", Long.class)
                .setParameter("email", this.email).getSingleResult();
        /** @cargaIntrinseca 1 */
        if (autorId != null){
            throw new AutorException("O email já existe");
        }
    }
}
