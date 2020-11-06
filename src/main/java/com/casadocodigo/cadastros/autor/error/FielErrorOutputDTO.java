package com.casadocodigo.cadastros.autor.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Classe que representa campos de erros da {@link ValidationErrorsOutputDTO}
 *  @cargaIntrinseca 0 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FielErrorOutputDTO {
    private String field;
    private String message;
    private Object parameter;
}
