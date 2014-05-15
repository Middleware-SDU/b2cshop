package cn.edu.sdu.b2cshop.system.wares.controllers;

import play.data.Form;
import play.mvc.Result;
import play.mvc.With;
import cn.edu.sdu.b2cshop.core.db.jpa.OptionalTransactionalAction;
import cn.edu.sdu.b2cshop.core.db.jpa.Transactional;
import cn.edu.sdu.b2cshop.system.wares.views.html.item_info;
import cn.edu.sdu.b2cshop.system.wares.views.html.item_search;
import cn.edu.sdu.b2cshop.system.wares.views.html.item_add;
import cn.edu.sdu.b2cshop.system.commons.controllers.BaseController;
import cn.edu.sdu.b2cshop.system.wares.forms.*;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;
import cn.edu.sdu.b2cshop.system.wares.models.WareCategory;

@With({
    OptionalTransactionalAction.class
})
public class WareController extends BaseController {

    public Result search() {
        return ok(item_search.render());
    }

    @Transactional(readOnly=true)
    public Result view(Long wareId) {
        Ware ware = Ware.dao.find(wareId);
        if(ware == null) {
            return forbidden("休息一下吧！！");
        }
        return ok(item_info.render(ware));
    }

    public Result add() {
        return ok(item_add.render());
    }

    @Transactional
    public Result save() {
        Form<AddWareForm> form = Form.form(AddWareForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(form.errorsAsJson());
        }
        AddWareForm formData = form.get();
        Ware ware = new Ware();
        ware.setCategory(WareCategory.dao.find(2L));
        ware.setCode(formData.code);
        ware.setName(formData.name);
        ware.setDescription(formData.description);
        ware.setPrice(formData.price);
        ware.setDiscount(formData.discount);
        ware.setLogopath("images/wares/0/0/dxwl4.jpg");
        Ware.dao.save(ware);
        return redirect(cn.edu.sdu.b2cshop.system.wares.controllers.routes.WareCategoryController.view(2));
    }
}
