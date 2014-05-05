package cn.edu.sdu.b2cshop.system.wares.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import cn.edu.sdu.b2cshop.system.commons.BaseModel;

@Entity
public class WareStyle extends BaseModel {

    private static final long serialVersionUID = 7916096039730871508L;

    @Column(length=10)
    private String color;

    public WareStyle() {}

    public WareStyle(String color) {
        this.color = color;
    }

    // TODO : some other styles or implement it in sub class

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
