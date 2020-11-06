package com.casadocodigo.cadastros.autor.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/** @cargaIntrinseca 0 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AutorException extends RuntimeException{

    public AutorException(final String message) {
        this(message, null);
    }

    public AutorException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
