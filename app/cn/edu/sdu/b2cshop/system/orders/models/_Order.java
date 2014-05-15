package cn.edu.sdu.b2cshop.system.orders.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import cn.edu.sdu.b2cshop.system.carts.models.Cart;
import cn.edu.sdu.b2cshop.system.commons.BaseModel;
import cn.edu.sdu.b2cshop.system.orders.daos._OrderDAO;
import cn.edu.sdu.b2cshop.system.orders.daos.impls._OrderDAOImpl;

@Entity
public class _Order extends BaseModel{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Cart cart;

    @OneToMany(mappedBy="_order", cascade={CascadeType.PERSIST})
    private List<_OrderItem> items = new ArrayList<_OrderItem>();

    private Date forDate;

    public static _OrderDAO dao = new _OrderDAOImpl();

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

    public void addItem(_OrderItem oi) {
        if(this.items != null) {
            if(this.items.contains(oi)) {
                this.items.set(this.items.indexOf(oi), oi);
            } else {
                this.items.add(oi);
            }
        }
    }

    public void removeItem(_OrderItem oi) {
        if(this.items != null && this.items.contains(oi)) {
            this.items.remove(oi);
        }
    }

}
