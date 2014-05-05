package cn.edu.sdu.b2cshop.system.users.daos.impls;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import play.Play;
import akka.actor.FSM.State;
import cn.edu.sdu.b2cshop.system.commons.daos.AbstractBaseModelDAO;
import cn.edu.sdu.b2cshop.system.users.daos.UserDAO;
import cn.edu.sdu.b2cshop.system.users.models.User;


@Repository
public class UserDAOImpl extends AbstractBaseModelDAO<User> implements UserDAO {

}
