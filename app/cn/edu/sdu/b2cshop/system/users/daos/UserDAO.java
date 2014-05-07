package cn.edu.sdu.b2cshop.system.users.daos;

import cn.edu.sdu.b2cshop.system.commons.daos.BaseModelDAO;
import cn.edu.sdu.b2cshop.system.users.models.User;

public interface UserDAO extends BaseModelDAO<User> {

    User findByUsername(String username);

    User authenticate(String username, String password);

}
