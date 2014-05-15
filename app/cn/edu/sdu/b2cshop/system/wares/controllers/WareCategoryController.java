package cn.edu.sdu.b2cshop.system.wares.controllers;

import java.util.List;

import play.mvc.Result;
import play.mvc.With;
import cn.edu.sdu.b2cshop.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.b2cshop.core.db.jpa.Transactional;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;
import cn.edu.sdu.b2cshop.system.wares.models.WareCategory;
import cn.edu.sdu.b2cshop.system.wares.views.html.*;

@With({
    OptionalTransactionalAction.class
})
public class WareCategoryController  extends BaseController {

    public Result index() {
        return ok(category_list.render());
    }

    @Transactional(readOnly=true)
    public Result view(Long id) {
        WareCategory wareCategory = WareCategory.dao.find(id);
        if(wareCategory == null) {
            return forbidden("休息一下吧！！");
        }
        List wares = Ware.dao.findByCategory(id);
        return ok(item_list.render(wares));
    }

}
