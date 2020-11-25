package com.casadocodigo.cadastros.estados;

import com.casadocodigo.cadastros.pais.Pais;
import com.casadocodigo.cadastros.validator.ExistsId;
import com.casadocodigo.cadastros.validator.UniqueValueForEntity;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/** @cargaIntrinseca 1 */
@Getter
public class EstadoCadastro {

    @NotBlank
    @UniqueValueForEntity(domainClass = Estado.class, fieldName = "pais", relationFieldName = "nome")
    private String nome;

    @NotNull
    @Positive
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    //1
    public Estado toModel() {
        return new Estado(this.nome, this.idPais);
    }
}
