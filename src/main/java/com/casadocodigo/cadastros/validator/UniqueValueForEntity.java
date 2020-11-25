package com.casadocodigo.cadastros.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = UniqueValueForEntityValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValueForEntity {

    String message() default "{com.casadocodigo.cadastros.uniquevalueforentity}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String relationFieldName();

    String fieldName();

    Class<?> domainClass();
}
