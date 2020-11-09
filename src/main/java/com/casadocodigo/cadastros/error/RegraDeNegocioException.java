package com.casadocodigo.cadastros.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/** @cargaIntrinseca 0 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegraDeNegocioException extends RuntimeException{

    public RegraDeNegocioException(final String message) {
        this(message, null);
    }

    public RegraDeNegocioException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
