package cn.edu.sdu.b2cshop.system.users.daos.impls;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import cn.edu.sdu.b2cshop.system.commons.daos.AbstractBaseModelDAO;
import cn.edu.sdu.b2cshop.system.users.daos.UserDAO;
import cn.edu.sdu.b2cshop.system.users.models.User;


@Repository
public class UserDAOImpl extends AbstractBaseModelDAO<User> implements UserDAO {

    @Override
    public User findByUsername(String username) {
        String hql = "from User where username = :username";
        TypedQuery<User> query = createQuery(hql).setParameter("username", username);
        return getSingleResultOrNull(query);
    }

    @Override
    public User authenticate(String username, String password) {
        String hql = "from User where username = :username and password = :password";
        TypedQuery<User> query = createQuery(hql).setParameter("username", username).setParameter("password", password);
        return getSingleResultOrNull(query);
    }

}
