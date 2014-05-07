package cn.edu.sdu.b2cshop.system.orders.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.edu.sdu.b2cshop.system.carts.models.Cart;
import cn.edu.sdu.b2cshop.system.commons.BaseModel;

@Entity
public class _Order extends BaseModel{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Cart cart;

    @OneToMany(mappedBy="_order")
    private List<_OrderItem> items;

    private Date forDate;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<_OrderItem> getItems() {
        return items;
    }

    public void setItems(List<_OrderItem> items) {
        this.items = items;
    }

    public Date getForDate() {
        return forDate;
    }

    public void setForDate(Date forDate) {
        this.forDate = forDate;
    }
}
