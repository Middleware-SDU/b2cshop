package cn.edu.sdu.b2cshop.system.commons.controllers;

import java.util.List;

import play.Logger;
import play.data.Form;
import play.libs.Crypto;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;
import views.html.web.home;
import views.html.web.login;
import views.html.web.register;
import cn.edu.sdu.b2cshop.application.utils.ContextHelper;
import cn.edu.sdu.b2cshop.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.b2cshop.core.db.jpa.Transactional;
import cn.edu.sdu.b2cshop.system.users.forms.AddUserForm;
import cn.edu.sdu.b2cshop.system.users.models.User;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;


@With({
    OptionalTransactionalAction.class
})
public class AuthController extends Controller {

    static final String COOKIE_KEY_REMEMBER_ME = "_remember_me";

    public static class Login {
        public String username;
        public String password;

        public String validate() {
            User user = User.dao.authenticate(username, password);
            if (user == null) {
                Logger.info("Error!");
                return "Login error";
            }
            this.username = user.getUsername();
            response().setCookie(COOKIE_KEY_REMEMBER_ME, Crypto.sign(username) + "-" + username, 30 * 24 * 60 * 60);
            ContextHelper.setLoggedUser(user);
            return null;
        }
    }

    public Result registerUI() {
        Logger.debug("AuthController.registerUI");
        return ok(register.render());
    }

    public Result loginUI() {
        Logger.debug("AuthController.loginUI");
        return ok(login.render());
    }

    @Transactional
    public Result register() {
        Logger.debug("AuthController.register");

        // validate form
        Form<AddUserForm> form = Form.form(AddUserForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }
        AddUserForm formData = form.get();
        if (!formData.confirmPassword.equals(formData.password)) {
            form.reject("confirmPassword", "password is not same as confirm");
        }
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }

        User user = new User(formData.username, formData.password);
        user.setRealname(user.getUsername());
        User.dao.save(user);

        return ok(login.render());
    }

    @Transactional(readOnly=true)
    public Result login() {
        Logger.debug("AuthController.login");
        Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            Logger.debug("login error: " + loginForm.errors().toString());
            flash().put("error", loginForm.globalError().message());
            flash().put("username", loginForm.data().get("username"));
            flash().put("password", loginForm.data().get("password"));
            return redirect(routes.AuthController.loginUI());
        }
        session("username", loginForm.get().username);
        User user = ContextHelper.getLoggedUser();
        if(user.isAdmin()) {
            return ok(views.html.back.category_list.render());
        }
        return ok(home.render());
    }

    @Transactional
    public Result logout() {
        Logger.debug("AuthController.loginout");
        // clear session
        session().clear();
        // remove 'rememberme' cookie
        response().discardCookie(COOKIE_KEY_REMEMBER_ME);
        List<Ware> wares = Ware.dao.findAll();
        return ok(home.render(wares));
    }

}
