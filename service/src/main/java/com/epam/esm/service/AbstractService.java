package com.epam.esm.service;

import com.epam.esm.dao.CRDDao;
import com.epam.esm.exceptions.DaoException;
import com.epam.esm.exceptions.IncorrectParameterException;
import com.epam.esm.validator.IdentifiableValidator;
import org.springframework.util.MultiValueMap;

import java.util.List;

/**
 * Class {@code AbstractService} is implementation of interface {@link CRDService} and is designed for basic work with objects.
 *
 * @param <T> the type parameter
 * @author Anzhalika Dziarkach
 * @version 1.0
 */
public abstract class AbstractService<T> implements CRDService<T> {
    protected final CRDDao<T> dao;

    public AbstractService(CRDDao<T> dao) {
        this.dao = dao;
    }

    @Override
    public T getById(long id) throws DaoException, IncorrectParameterException {
        IdentifiableValidator.validateId(id);
        return dao.getById(id);
    }

    @Override
    public List<T> getAll() throws DaoException {
        return dao.getAll();
    }

    @Override
    public void removeById(long id) throws DaoException, IncorrectParameterException {
        IdentifiableValidator.validateId(id);
        dao.removeById(id);
    }

    protected String getSingleRequestParameter(MultiValueMap<String, String> requestParams, String parameter) {
        if (requestParams.containsKey(parameter)) {
            return requestParams.get(parameter).get(0);
        } else {
            return null;
        }
    }
}
