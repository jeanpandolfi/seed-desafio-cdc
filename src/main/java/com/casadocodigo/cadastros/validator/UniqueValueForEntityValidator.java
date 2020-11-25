package com.casadocodigo.cadastros.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueForEntityValidator implements ConstraintValidator<UniqueValueForEntity, Object> {

    private String domainAttribute;
    private String relationAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValueForEntity constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        relationAttribute = constraintAnnotation.relationFieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select 1 from "+klass.getName()+" e where e."+domainAttribute+"."+relationAttribute+" =: value");
        List<?> list = query.setParameter("value", value).getResultList();
        return list.isEmpty();
    }
}
