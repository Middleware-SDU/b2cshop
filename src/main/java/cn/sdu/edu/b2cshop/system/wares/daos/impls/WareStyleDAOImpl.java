package cn.sdu.edu.b2cshop.system.wares.daos.impls;

import org.springframework.stereotype.Service;

import cn.sdu.edu.b2cshop.core.db.AbstractDAO;
import cn.sdu.edu.b2cshop.system.wares.daos.WareStyleDAO;
import cn.sdu.edu.b2cshop.system.wares.models.WareStyle;

@Service("wareStyleDAO")
public class WareStyleDAOImpl extends AbstractDAO<WareStyle, Long> implements WareStyleDAO<WareStyle> {

}
