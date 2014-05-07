package cn.edu.sdu.b2cshop.system.orders.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;
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
}
