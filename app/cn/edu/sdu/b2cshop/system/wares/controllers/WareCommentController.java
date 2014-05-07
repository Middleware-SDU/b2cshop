package cn.edu.sdu.b2cshop.system.wares.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;
import cn.edu.sdu.b2cshop.system.wares.views.html.comment_add;
import cn.edu.sdu.b2cshop.system.wares.views.html.comment_list;

public class WareCommentController extends BaseController{

    public Result view(Long wareId){
        return ok(comment_list.render());
    }

    public Result add(Long wareId){
        return ok(comment_add.render());
    }
}
