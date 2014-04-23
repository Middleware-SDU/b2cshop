package cn.sdu.edu.b2cshop.system.wares.daos.impls;

import org.springframework.stereotype.Service;

import cn.sdu.edu.b2cshop.core.db.AbstractDAO;
import cn.sdu.edu.b2cshop.system.wares.daos.WareCommentDAO;
import cn.sdu.edu.b2cshop.system.wares.models.WareComment;

@Service("wareCommentDAO")
public class WareCommentDAOImpl extends AbstractDAO<WareComment, Long> implements WareCommentDAO<WareComment> {

}
