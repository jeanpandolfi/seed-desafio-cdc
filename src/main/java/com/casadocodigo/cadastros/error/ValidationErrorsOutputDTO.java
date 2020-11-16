package com.casadocodigo.cadastros.error;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de retorno para reponses com Exceptions
 *  @cargaIntrinseca 1 */
public class ValidationErrorsOutputDTO {

    @Getter
    private List<String> globalErrorsMessages = new ArrayList<>();
    /** @cargaIntrinseca 1 */
    private List<FielErrorOutputDTO> fieldErrors = new ArrayList<>();

    @Getter @Setter
    private String path;

    public void addGlobalError(String message){
        this.globalErrorsMessages.add(message);
    }

    public void addFieldError(String field, String message, Object parameter){
        FielErrorOutputDTO fielErrorOutputDTO = new FielErrorOutputDTO(field, message, parameter);
        fieldErrors.add(fielErrorOutputDTO);
    }

    public List<FielErrorOutputDTO> getErrors() {
        return fieldErrors;
    }

}
