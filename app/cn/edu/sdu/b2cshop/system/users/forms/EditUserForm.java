package cn.edu.sdu.b2cshop.system.users.forms;

import java.util.ArrayList;
import java.util.List;
import play.data.validation.Constraints.MaxLength;
import play.data.validation.ValidationError;

public class EditUserForm {

    private Long id;
    private String username;

    @MaxLength(20)
    public String password;

    @MaxLength(20)
    public String passwordNew;
    @MaxLength(20)
    public String confirmPassword;

    public List<ValidationError> validate() {
        List<ValidationError> errors = new ArrayList<ValidationError>();
        return errors.size() == 0 ? null : errors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
