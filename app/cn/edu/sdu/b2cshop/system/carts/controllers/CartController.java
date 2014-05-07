package cn.edu.sdu.b2cshop.system.carts.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.carts.views.html.cart_list;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;

public class CartController extends BaseController{

    public Result view (Long userId){
        return ok(cart_list.render());
    }

}
