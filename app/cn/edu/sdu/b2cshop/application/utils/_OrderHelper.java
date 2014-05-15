package cn.edu.sdu.b2cshop.application.utils;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import cn.edu.sdu.b2cshop.system.orders.models._Order;
import cn.edu.sdu.b2cshop.system.orders.models._OrderItem;
import play.mvc.Http.Context;


public class _OrderHelper {

    public static final String SESSION_KEY_ORDER = "_order";

    /**
     * Get _order from current HTTP session
     */
    public static _Order getOrder() {
        return (_Order) JSON.parseObject(Context.current().session().get(SESSION_KEY_ORDER), _Order.class);
    }

    /**
     * Put _order to current HTTP session
     * 
     * @param user
     */
    public static void setOrder(_Order _order) {
        Context.current().session().put(SESSION_KEY_ORDER, JSON.toJSONString(_order));
    }

    public static List<_OrderItem> getOrderItems() {
        _Order o = getOrder();
        if(o == null ) {
            return new ArrayList<_OrderItem>();
        }
        return getOrder().getItems();
    }

    /**
     * add orderItem to order
     * 
     * @param user
     */
    public static void addToOrder(_OrderItem item) {
        _Order o = getOrder();
        if(o == null) {
            o = new _Order();
        }
        o.addItem(item);
        Context.current().session().put(SESSION_KEY_ORDER, JSON.toJSONString(o));
    }

    /**
     * 
     * @param item
     */
    public static void removeFromOrder(_OrderItem item) {
        _Order o = getOrder();
        if(o != null) {
            o.removeItem(item);
        } else {
            o = new _Order();
        }
        Context.current().session().put(SESSION_KEY_ORDER, JSON.toJSONString(o));
    }

    public static Double getTotalPrice() {
        _Order o = getOrder();
        if(o == null) {
            return 0.0;
        }
        double total = 0.0;
        for(_OrderItem oi : o.getItems()) {
            total += oi.getCount() * Double.parseDouble(oi.getWare().getRealPrice());
        }
        return total;
    }

}
