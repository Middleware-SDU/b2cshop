package cn.edu.sdu.b2cshop.system.orders.controllers;

import play.mvc.Result;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;
import cn.edu.sdu.b2cshop.system.orders.views.html.order_info;

public class OrderController extends BaseController{


    public Result view(Long orderId){
        return ok(order_info.render());
    }
}
