package cn.edu.sdu.b2cshop.system.users.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;

@Entity
public class Favorite extends BaseModel{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private User user;

    private String name;

    @ManyToOne
    private Favorite parent;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Favorite getParent() {
        return parent;
    }

    public void setParent(Favorite parent) {
        this.parent = parent;
    }
}
