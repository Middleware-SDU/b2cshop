package cn.edu.sdu.b2cshop.system.users.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.users.views.html.favorite;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;

public class FavoriteController extends BaseController {

    public Result view (Long userId){
        return ok(favorite.render());
    }
}
