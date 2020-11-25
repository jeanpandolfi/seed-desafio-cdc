package com.casadocodigo.cadastros.fluxopagamento;

import com.casadocodigo.cadastros.pais.Pais;
import com.casadocodigo.cadastros.validator.CEP;
import com.casadocodigo.cadastros.validator.CheckPaisAndEstado;
import com.casadocodigo.cadastros.validator.ExistsCPFouCNPJ;
import com.casadocodigo.cadastros.validator.ExistsId;
import lombok.Getter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/** @cargaIntrinseca 0*/
@Getter
@ExistsCPFouCNPJ
@CheckPaisAndEstado
public class ClienteCadastro {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CPF
    private String documentoCpf;
    @CNPJ
    private String documentoCnpj;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @Positive
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long IdPais;
    private String IdEstado;
    @NotBlank
    private String telefone;
    @CEP
    private String cep;
}
