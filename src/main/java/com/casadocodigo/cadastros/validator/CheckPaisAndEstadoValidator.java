package com.casadocodigo.cadastros.validator;

import com.casadocodigo.cadastros.fluxopagamento.ClienteCadastro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CheckPaisAndEstadoValidator implements ConstraintValidator<CheckPaisAndEstado, ClienteCadastro> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(ClienteCadastro value, ConstraintValidatorContext context) {
        List<Long> idsEstados = manager.createQuery("select e.id from Estado e where e.pais.id = :id", Long.class).setParameter("id", value.getIdPais()).getResultList();
        return !idsEstados.isEmpty();
    }
}
