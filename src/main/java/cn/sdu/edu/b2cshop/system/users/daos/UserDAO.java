package cn.sdu.edu.b2cshop.system.users.daos;

import cn.sdu.edu.b2cshop.core.db.DAO;
import cn.sdu.edu.b2cshop.system.users.models.User;

public interface UserDAO<T extends User> extends DAO<T, Long> {

}
