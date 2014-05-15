package cn.edu.sdu.b2cshop.system.wares.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;
import cn.edu.sdu.b2cshop.system.wares.daos.WareCategoryDAO;
import cn.edu.sdu.b2cshop.system.wares.daos.impls.WareCategoryDAOImpl;

@Entity
public class WareCategory extends BaseModel{

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer level;

    @ManyToOne
    private WareCategory parent;

    public static WareCategoryDAO dao = new WareCategoryDAOImpl();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public WareCategory getParent() {
        return parent;
    }

    public void setParent(WareCategory parent) {
        this.parent = parent;
    }
}
