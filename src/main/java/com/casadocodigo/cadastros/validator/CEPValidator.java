package com.casadocodigo.cadastros.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CEPValidator implements ConstraintValidator<CEP, String> {

    public static final Pattern FORMATED = Pattern.compile("(\\d{5})[-](\\d{3})");
    public static final Pattern UNFORMATED = Pattern.compile("(\\d{8})");


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value != null && !value.trim().isEmpty()){
            return FORMATED.matcher(value).matches() || UNFORMATED.matcher(value).matches();
        }else{
            return false;
        }
    }
}
