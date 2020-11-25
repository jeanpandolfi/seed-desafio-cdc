package com.casadocodigo.cadastros.validator;

import com.casadocodigo.cadastros.fluxopagamento.ClienteCadastro;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsCPFouCNPJValidator implements ConstraintValidator<ExistsCPFouCNPJ, ClienteCadastro> {

    @Override
    public boolean isValid(ClienteCadastro value, ConstraintValidatorContext context) {
        return !(value.getDocumentoCnpj() == null && value.getDocumentoCpf() == null);
    }
}
