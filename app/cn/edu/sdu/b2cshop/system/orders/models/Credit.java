package cn.edu.sdu.b2cshop.system.orders.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;

@Entity
public class Credit extends BaseModel{

    private static final long serialVersionUID = 1L;

    @OneToOne
    private _Order _order;

    private Integer count;

    public _Order get_order() {
        return _order;
    }

    public void set_order(_Order _order) {
        this._order = _order;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
