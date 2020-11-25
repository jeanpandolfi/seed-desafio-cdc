package com.casadocodigo.cadastros.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CheckPaisAndEstadoValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPaisAndEstado {

    String message() default "O país selecionado possui Estados associados e não foi passado um estado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
