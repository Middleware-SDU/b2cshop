package cn.sdu.edu.b2cshop.system.users.daos.impls;

import org.springframework.stereotype.Service;

import cn.sdu.edu.b2cshop.core.db.AbstractDAO;
import cn.sdu.edu.b2cshop.system.users.daos.UserAddressDAO;
import cn.sdu.edu.b2cshop.system.users.models.UserAddress;

@Service("userAddressDAO")
public class UserAddressDAOImpl extends AbstractDAO<UserAddress, Long> implements UserAddressDAO<UserAddress> {

}
