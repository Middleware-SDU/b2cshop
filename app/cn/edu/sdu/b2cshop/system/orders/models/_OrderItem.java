package cn.edu.sdu.b2cshop.system.orders.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import cn.edu.sdu.b2cshop.system.commons.BaseModel;
import cn.edu.sdu.b2cshop.system.orders.daos._OrderItemDAO;
import cn.edu.sdu.b2cshop.system.orders.daos.impls._OrderItemDAOImpl;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;

@Entity
public class _OrderItem extends BaseModel{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private _Order _order;

    @ManyToOne
    private Ware ware;

    @Column(nullable=false)
    private Integer count;

    public static _OrderItemDAO dao = new _OrderItemDAOImpl();

    public _OrderItem() {}

    public _OrderItem(Ware ware, Integer count) {
        this.ware = ware;
        this.count = count;
    }

    public _Order get_order() {
        return _order;
    }

    public void set_order(_Order _order) {
        this._order = _order;
    }

    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((ware == null) ? 0 : ware.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        _OrderItem other = (_OrderItem) obj;
        if (ware == null) {
            if (other.ware != null) return false;
        } else if (!ware.equals(other.ware)) return false;
        return true;
    }
    

}
