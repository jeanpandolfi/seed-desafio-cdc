package com.casadocodigo.cadastros.autor;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
public class AutorCadastro {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "O email é inválido")
    private String email;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 400, message = "A descrição não pode passar de 400 caracteres")
    private String descricao;

    public Autor toEntity(){
        return new Autor( this.nome, this.email, this.descricao, LocalDateTime.now());
    }
}
