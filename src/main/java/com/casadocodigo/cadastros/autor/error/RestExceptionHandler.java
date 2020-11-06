package com.casadocodigo.cadastros.autor.error;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Classe que intercepta as Exceptions e trata-as
 * @cargaIntrinseca 2 */
@RequiredArgsConstructor
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ObjectError> globalErrors = ex.getBindingResult().getGlobalErrors();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        /** @cargaIntrinseca 1 */
        ValidationErrorsOutputDTO validationErrorsOutputDTO =  buildValidationErrors(globalErrors, fieldErrors);
        validationErrorsOutputDTO.setPath(request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(validationErrorsOutputDTO);
    }

    /** @cargaIntrinseca 1 */
    @ExceptionHandler({AutorException.class})
    public ResponseEntity<Object> handleAutorException(AutorException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    /**
     * Constroi um objeto {@link ValidationErrorsOutputDTO} com base nos errors da request
     * @param globalErrors erros globais da request
     * @param fieldErrors campos de erros da request */
    private ValidationErrorsOutputDTO buildValidationErrors(List<ObjectError> globalErrors, List<FieldError> fieldErrors) {
        ValidationErrorsOutputDTO validationErrors = new ValidationErrorsOutputDTO();

        globalErrors.forEach( error -> validationErrors.addGlobalError(getErrorMessage(error)));

        fieldErrors.forEach(error -> {
            String errorMessage = getErrorMessage(error);
            validationErrors.addFieldError(error.getField(), errorMessage, error.getRejectedValue());
        });
        return validationErrors;
    }

    /**
     * Busca a mensagem em {@link messages.properties} com base no ObjectError
     * @param error ObjectError
     * @return mensagem do messages.properties */
    private String getErrorMessage(ObjectError error) {
        return messageSource.getMessage(error, LocaleContextHolder.getLocale());
    }

}
