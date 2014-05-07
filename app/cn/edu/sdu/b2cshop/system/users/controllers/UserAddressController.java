package cn.edu.sdu.b2cshop.system.users.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.users.views.html.send_notes;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;

public class UserAddressController extends BaseController{

    public Result view(Long userId){
        return ok(send_notes.render());
    }
}
