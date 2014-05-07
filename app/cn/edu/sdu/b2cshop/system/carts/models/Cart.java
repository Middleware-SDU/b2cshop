package cn.edu.sdu.b2cshop.system.carts.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;
import cn.edu.sdu.b2cshop.system.orders.models._Order;
import cn.edu.sdu.b2cshop.system.users.models.User;

@Entity
public class Cart extends BaseModel{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private User user;

    @OneToMany
    private List<_Order> _orders;

    private Double total;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<_Order> get_orders() {
        return _orders;
    }

    public void set_orders(List<_Order> _orders) {
        this._orders = _orders;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
