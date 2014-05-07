package cn.edu.sdu.b2cshop.application.utils;

import cn.edu.sdu.b2cshop.system.users.models.User;
import play.mvc.Http.Context;


public class ContextHelper {

    public static final String CTX_KEY_LOGGED_USER = "_logged_user";

    /**
     * Get logger user from current HTTP context
     */
    public static User getLoggedUser() {
        return (User) Context.current().args.get(CTX_KEY_LOGGED_USER);
    }

    /**
     * Put logger user to current HTTP context
     * 
     * @param user
     */
    public static void setLoggedUser(User user) {
        Context.current().args.put(CTX_KEY_LOGGED_USER, user);
    }

}
