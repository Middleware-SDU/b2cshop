package cn.edu.sdu.b2cshop.system.commons.controllers;


import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.web.home;

public class HomePageController extends Controller {
    
    public Result index() {
        Logger.debug("HomepageController.index");
        return ok(home.render());
    }

}
