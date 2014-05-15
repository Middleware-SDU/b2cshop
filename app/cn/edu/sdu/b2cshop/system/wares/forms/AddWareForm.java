package cn.edu.sdu.b2cshop.system.wares.forms;

import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;

public class AddWareForm {

    @Required
    @MaxLength(30)
    public String code;

    @Required
    public String name;

    public String description;

    @Required
    public Double price;

    @Required
    public Integer discount;


}
