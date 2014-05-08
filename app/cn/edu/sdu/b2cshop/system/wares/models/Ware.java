package cn.edu.sdu.b2cshop.system.wares.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;


@Entity
public class Ware extends BaseModel {

    private static final long serialVersionUID = -5833588595970047358L;

    @Column(length=30, nullable=false)
    private String code;

    @Column(length=10, nullable=false)
    private String name;

    @Column(length=100)
    private String description;

    @Column(length=100)
    private String logopath;

    @Column(nullable=false)
    private Double price;

    private Integer discount;

    @Column(nullable=false)
    private Long stack;

    @ManyToOne
    private WareCategory category;

    @OneToMany(mappedBy = "ware", cascade = { CascadeType.REMOVE }, targetEntity = WareComment.class)
    private List<WareComment> comments = new ArrayList<WareComment>();

    public Ware() {}

    public Ware(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogopath() {
        return logopath;
    }

    public void setLogopath(String logopath) {
        this.logopath = logopath;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Long getStack() {
        return stack;
    }

    public void setStack(Long stack) {
        this.stack = stack;
    }

    public List<WareComment> getComments() {
        return comments;
    }

    public void setComments(List<WareComment> comments) {
        this.comments = comments;
    }

    /**
     * Add a comment to comments
     * @param comment
     * @return
     */
    public boolean addComment(WareComment comment) {
        if(this.comments != null && !this.comments.contains(comment)) {
            this.comments.add(comment);
            return true;
        }
        return false;
    }

    /**
     * Remove a comment from comments
     * @param comment
     */
    public void remove(WareComment comment) {
        if(this.comments != null && this.comments.contains(comment)) {
            this.comments.remove(comment);
        }
    }

}
