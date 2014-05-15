package cn.edu.sdu.b2cshop.system.carts.controllers;

import play.mvc.Result;
import play.mvc.With;
import cn.edu.sdu.b2cshop.system.carts.views.html.tradequery;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;
import cn.edu.sdu.b2cshop.system.orders.models._Order;
import cn.edu.sdu.b2cshop.system.orders.models._OrderItem;
import cn.edu.sdu.b2cshop.system.users.models.User;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;
import cn.edu.sdu.b2cshop.application.utils.ContextHelper;
import cn.edu.sdu.b2cshop.application.utils._OrderHelper;
import cn.edu.sdu.b2cshop.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.b2cshop.core.db.jpa.Transactional;

import java.util.Date;

@With({
    OptionalTransactionalAction.class
})
public class TradeController extends BaseController{

    public Result view(Long userId){
        return ok(tradequery.render());
    }

    @Transactional
    public Result buy() {
        User loggerUser = ContextHelper.getLoggedUser();
        if(loggerUser == null) {
            return forbidden("休息一下吧！！");
        }
        _Order o = _OrderHelper.getOrder();
        if(o != null) {
            for(_OrderItem oi : o.getItems()) {
                Ware w = oi.getWare();
                w.updateStack(oi.getCount());
                Ware.dao.merge(w);
            }
        }
        o.setForDate(new Date());
        _Order.dao.save(o);
        _OrderHelper.setOrder(null);
        return redirect(cn.edu.sdu.b2cshop.system.commons.controllers.routes.HomePageController.index());
    }
}
