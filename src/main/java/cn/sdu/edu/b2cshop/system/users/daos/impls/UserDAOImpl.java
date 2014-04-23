package cn.sdu.edu.b2cshop.system.users.daos.impls;

import org.springframework.stereotype.Service;

import cn.sdu.edu.b2cshop.core.db.AbstractDAO;
import cn.sdu.edu.b2cshop.system.users.daos.UserDAO;
import cn.sdu.edu.b2cshop.system.users.models.User;


@Service("userDAO")
public class UserDAOImpl extends AbstractDAO<User, Long> implements UserDAO<User> {

}
