package cn.edu.sdu.b2cshop.system.wares.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;
import cn.edu.sdu.b2cshop.system.wares.views.html.item_list;

public class WareCategoryController  extends BaseController {
    public Result view(Long id) {
        return ok(item_list.render());
    }
}
