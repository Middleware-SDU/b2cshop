package cn.edu.sdu.b2cshop.system.commons.controllers;


import java.util.List;

import play.Logger;
import play.mvc.Result;
import play.mvc.With;
import views.html.web.home;
import cn.edu.sdu.b2cshop.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.b2cshop.core.db.jpa.Transactional;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;

@With({
    OptionalTransactionalAction.class
})
public class HomePageController extends BaseController {

    @Transactional
    public Result index() {
        Logger.debug("HomepageController.index");
        List<Ware> wares = Ware.dao.findAll();
        return ok(home.render(wares));
    }

}
