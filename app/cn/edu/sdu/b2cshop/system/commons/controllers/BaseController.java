package cn.edu.sdu.b2cshop.system.commons.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import cn.edu.sdu.b2cshop.application.utils.ContextHelper;
import cn.edu.sdu.b2cshop.core.db.jpa.JPA;
import cn.edu.sdu.b2cshop.system.users.models.User;
import play.Logger;
import play.libs.F.Callback0;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Controller;
import play.mvc.Http.Context;
import play.mvc.Security;
import play.mvc.SimpleResult;
import play.mvc.With;

/**
 * Parent class of all com.kernelogic.process6.controllers which user needs to login to access
 * 
 * @author sdcsyyg
 */
@With({
    BaseController.CommonAction.class
})
public abstract class BaseController extends Controller {

    @org.springframework.stereotype.Controller
    @Scope("prototype")
    public static class CommonAction extends Action.Simple {

        @Override
        public Promise<SimpleResult> call(final Context ctx) throws Throwable {
            Logger.debug("BaseController.CommonAction.call");

            JPA.withTransaction(new Callback0() {
                public void invoke() {
                    // put the logged user into HTTP context
                    User loggedUser = User.dao.findByUsername(ctx.session().get("username"));
                    ContextHelper.setLoggedUser(loggedUser);
                    JPA.em().merge(loggedUser);
                    Logger.debug("  Current logged user is " + loggedUser.getUsername() + "(" + loggedUser.getId() + ")");
                }
            });
            return delegate.call(ctx);
        }

    }

}
