package cn.edu.sdu.b2cshop.system.commons.daos;

import java.util.List;

import cn.edu.sdu.b2cshop.core.db.dao.AbstractDAO;
import cn.edu.sdu.b2cshop.system.commons.BaseModel;


public abstract class AbstractBaseModelDAO<T extends BaseModel> extends AbstractDAO<T, Long> implements BaseModelDAO<T> {

    public AbstractBaseModelDAO() {
        this.typeOfID = Long.class;
    }

}
