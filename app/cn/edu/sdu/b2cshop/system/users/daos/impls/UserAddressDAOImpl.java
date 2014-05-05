package cn.edu.sdu.b2cshop.system.users.daos.impls;

import org.springframework.stereotype.Repository;
import cn.edu.sdu.b2cshop.system.commons.daos.AbstractBaseModelDAO;
import cn.edu.sdu.b2cshop.system.users.daos.UserAddressDAO;
import cn.edu.sdu.b2cshop.system.users.models.UserAddress;


@Repository
public class UserAddressDAOImpl extends AbstractBaseModelDAO<UserAddress> implements UserAddressDAO {

}
