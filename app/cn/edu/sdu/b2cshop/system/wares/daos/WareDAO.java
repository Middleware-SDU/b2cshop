package cn.edu.sdu.b2cshop.system.wares.daos;

import java.util.List;

import cn.edu.sdu.b2cshop.system.commons.daos.BaseModelDAO;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;

public interface WareDAO extends BaseModelDAO<Ware> {

    List<Ware> findByCategory(Long categoryId);

}
