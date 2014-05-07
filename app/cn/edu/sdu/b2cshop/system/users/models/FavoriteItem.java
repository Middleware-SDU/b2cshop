package cn.edu.sdu.b2cshop.system.users.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;
import cn.edu.sdu.b2cshop.system.wares.models.Ware;

@Entity
public class FavoriteItem extends BaseModel{

    private static final long serialVersionUID = 1L;

    @ManyToOne
    private Favorite favorite;

    @ManyToOne
    private Ware ware;

    private Date forDate;

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }

    public Date getForDate() {
        return forDate;
    }

    public void setForDate(Date forDate) {
        this.forDate = forDate;
    }
}
