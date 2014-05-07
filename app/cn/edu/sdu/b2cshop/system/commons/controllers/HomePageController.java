package cn.edu.sdu.b2cshop.system.commons.controllers;


import play.Logger;
import play.mvc.Result;
import views.html.web.home_nologin;

public class HomePageController extends BaseController {

    public Result index() {
        Logger.debug("HomepageController.index");
        return ok(home_nologin.render());
    }

}
