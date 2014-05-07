package cn.edu.sdu.b2cshop.system.carts.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.carts.views.html.account_check;
import cn.edu.sdu.b2cshop.system.carts.views.html.tradequery;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;

public class TradeController extends BaseController{

    public Result view(Long userId){
        return ok(tradequery.render());
    }

    public Result check(Long userId,Long cartId){
        return ok(account_check.render());
    }
}
