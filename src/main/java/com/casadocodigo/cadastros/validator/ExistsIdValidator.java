package com.casadocodigo.cadastros.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Long> {

    private String domainAttribute;
    private Class<?> klass;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        domainAttribute = constraintAnnotation.fieldName();
        klass = constraintAnnotation.domainClass();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+" =: id");
        List<?> list = query.setParameter("id", id).getResultList();
        if(!list.isEmpty()) return true;
        else return false;
    }
}
