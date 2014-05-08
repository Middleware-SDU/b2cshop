package cn.edu.sdu.b2cshop.system.orders.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.orders.views.html.credit_query;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;

public class CreditController extends BaseController{

    public Result view(Long userId, Long creditId) {
        return ok(credit_query.render());
    }

}
