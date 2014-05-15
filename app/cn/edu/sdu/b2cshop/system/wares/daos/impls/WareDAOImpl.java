package cn.edu.sdu.b2cshop.system.wares.daos.impls;

import java.util.List;

import javax.persistence.TypedQuery;

import cn.edu.sdu.b2cshop.system.commons.daos.AbstractBaseModelDAO;
import cn.edu.sdu.b2cshop.system.wares.daos.WareDAO;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;

public class WareDAOImpl  extends AbstractBaseModelDAO<Ware> implements WareDAO {

    @Override
    public List<Ware> findByCategory(Long categoryId) {
        String hql = "from Ware where category.id = :categoryId";
        TypedQuery<Ware> query = createQuery(hql).setParameter("categoryId", categoryId);
        return query.getResultList();
    }

}
