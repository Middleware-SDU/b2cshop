package cn.edu.sdu.b2cshop.system.users.controllers;

import play.Logger;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.i18n.Messages;
import play.libs.Crypto;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.web.user_edit;
import cn.edu.sdu.b2cshop.application.utils.ContextHelper;
import cn.edu.sdu.b2cshop.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.b2cshop.core.db.jpa.Transactional;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;
import cn.edu.sdu.b2cshop.system.users.forms.AddUserForm;
import cn.edu.sdu.b2cshop.system.users.models.User;


@With({
    OptionalTransactionalAction.class
})
public class UserController extends BaseController {

    @Transactional
    public Result view(Long id) {
        Logger.debug("AuthController.view");
        User existingUser = User.dao.find(id);
        if (existingUser == null) {
            return notFound("该用户不存在！");
        }
        return ok(user_edit.render(existingUser));
    }

}
