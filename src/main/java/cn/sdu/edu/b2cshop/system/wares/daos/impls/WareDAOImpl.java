package cn.sdu.edu.b2cshop.system.wares.daos.impls;

import org.springframework.stereotype.Service;

import cn.sdu.edu.b2cshop.core.db.AbstractDAO;
import cn.sdu.edu.b2cshop.system.wares.daos.WareDAO;
import cn.sdu.edu.b2cshop.system.wares.models.Ware;

@Service("wareDAO")
public class WareDAOImpl extends AbstractDAO<Ware, Long> implements WareDAO<Ware> {

}
