package cn.sdu.edu.b2cshop.core.db;

import java.io.Serializable;
import java.util.List;

public interface DAO<T, ID extends Serializable> {

    List<T> find(List<ID> idList);

    T find(ID id);

    List<T> save(List<T> entityList);

    void remove(List<T> entityList);

    void removeByIds(List<ID> idList);

}
