package cn.sdu.edu.b2cshop.core.db;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, ID extends Serializable> {

    T find(ID id);

    Object update(T entity);

    void save(T entity);

    void save(List<T> entityList);

    public void remove(T entity);

    void remove(List<T> entityList);

    public void removeById(ID id);

    void removeByIds(List<ID> idList);

}
