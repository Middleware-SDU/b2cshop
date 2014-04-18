package cn.sdu.edu.b2cshop.core.db;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public abstract class AbstractDAO<T, ID extends Serializable> implements DAO<T, ID> {

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
    public T find(ID id) {
        return null;
    }

    @Override
    public List<T> find(List<ID> idList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> save(List<T> entityList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remove(List<T> entityList) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeByIds(List<ID> idList) {
        // TODO Auto-generated method stub
        
    }

}
