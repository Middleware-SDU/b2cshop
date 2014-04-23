package cn.sdu.edu.b2cshop.core.db;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class AbstractDAO<T, ID extends Serializable> implements DAO<T, ID> {

    @PersistenceContext protected EntityManager em;

    protected Class<T> typeOfT;
    protected Class<ID> typeOfID;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        if (types.length > 0) {
            this.typeOfT = (Class<T>) types[0];
        }
        if (types.length > 1) {
            this.typeOfID = (Class<ID>) types[1];
        }
    }

    @Override
    @Transactional(readOnly=true)
    public T find(ID id) {
        return em.find(typeOfT, id);
    }

    @Override
    public Object update(T entity) {
        return em.merge(entity);
    }

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public void save(List<T> entityList) {
        for(T t : entityList) {
            save(t);
        }
    }

    @Override
    public void remove(T entity) {
        remove(entity);
    }

    @Override
    public void remove(List<T> entityList) {
        for(T t : entityList) {
            remove(t);
        }
    }

    @Override
    public void removeById(ID id) {
        remove(em.getReference(typeOfT, id));
    }

    @Override
    public void removeByIds(List<ID> idList) {
        for(ID id : idList) {
            removeById(id);
        }
    }

}
