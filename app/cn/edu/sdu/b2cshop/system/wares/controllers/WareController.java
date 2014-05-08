package cn.edu.sdu.b2cshop.system.wares.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.wares.views.html.item_info;
import cn.edu.sdu.b2cshop.system.wares.views.html.item_search;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;

public class WareController extends BaseController {

    public Result search() {
        return ok(item_search.render());
    }

    public Result view(Long wareId) {
        return ok(item_info.render());
    }
}
