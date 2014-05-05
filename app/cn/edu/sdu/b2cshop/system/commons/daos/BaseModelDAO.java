package cn.edu.sdu.b2cshop.system.commons.daos;

import java.util.List;

import cn.edu.sdu.b2cshop.core.db.dao.DAO;
import cn.edu.sdu.b2cshop.system.commons.BaseModel;


public interface BaseModelDAO<T extends BaseModel> extends DAO<T, Long> {

}
