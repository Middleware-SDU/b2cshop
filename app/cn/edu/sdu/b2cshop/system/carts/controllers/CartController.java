package cn.edu.sdu.b2cshop.system.carts.controllers;

import com.alibaba.fastjson.JSON;

import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Result;
import play.mvc.With;
import cn.edu.sdu.b2cshop.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.b2cshop.core.db.jpa.Transactional;
import cn.edu.sdu.b2cshop.system.carts.views.html.cart_list;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;
import cn.edu.sdu.b2cshop.system.orders.models._OrderItem;
import cn.edu.sdu.b2cshop.system.users.models.User;
import cn.edu.sdu.b2cshop.application.utils.ContextHelper;
import cn.edu.sdu.b2cshop.application.utils._OrderHelper;

@With({
    OptionalTransactionalAction.class
})
public class CartController extends BaseController{

    @Transactional(readOnly=true)
    public Result addToCart (Long wareId){
        Ware ware = Ware.dao.find(wareId);
        User loggedUser = ContextHelper.getLoggedUser();
        if(ware == null || loggedUser == null) {
            return forbidden("休息一下吧！！");
        }
        _OrderItem item = new _OrderItem(ware, 1);
        _OrderHelper.addToOrder(item);
        return ok(cart_list.render(ware));
    }

    @Transactional
    public Result modifyCount(Long wareId) {
        Ware ware = Ware.dao.find(wareId);
        User loggedUser = ContextHelper.getLoggedUser();
        if(ware == null || loggedUser == null) {
            return forbidden("休息一下吧！！");
        }
        DynamicForm bindedForm = Form.form().bindFromRequest();
        String countStr = bindedForm.get("count");
        Integer count = 1;
        try {
            count = Integer.parseInt(countStr);
        } catch(Exception e) {
        }
        _OrderItem item = new _OrderItem(ware, count);
        _OrderHelper.addToOrder(item);
        return ok(JSON.toJSONString(_OrderHelper.getTotalPrice()));
    }

    @Transactional
    public Result removeFromCart(Long wareId) {
        Ware ware = Ware.dao.find(wareId);
        User loggedUser = ContextHelper.getLoggedUser();
        if(ware == null || loggedUser == null) {
            return forbidden("休息一下吧！！");
        }
        _OrderItem item = new _OrderItem(ware, 1);
        _OrderHelper.removeFromOrder(item);
        return ok(cart_list.render(ware));
    }

}
