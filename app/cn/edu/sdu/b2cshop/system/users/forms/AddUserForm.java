package cn.edu.sdu.b2cshop.system.users.forms;

import java.util.List;
import java.util.ArrayList;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.Constraints.Required;
import play.data.validation.ValidationError;
import cn.edu.sdu.b2cshop.system.users.models.User;

public class AddUserForm {

    @Required
    @MaxLength(30)
    public String username;

    @MaxLength(20)
    @Required
    public String password;

    @MaxLength(20)
    @Required(message = "This field must same as password.")
    public String confirmPassword;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();

        // 验证username是否重复
        if (User.dao.findByUsername(username) != null) {
            errors.add(new ValidationError("username", "用户名重复"));
        }

        return errors.size() == 0 ? null : errors;
    }

}
