package cn.edu.sdu.b2cshop.system.wares.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;
import cn.edu.sdu.b2cshop.system.users.models.User;

@Entity
public class WareComment extends BaseModel {

    private static final long serialVersionUID = -4134590725822454138L;

    public static enum Score {
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE
    }

    /* 评分 */
    @Column(nullable=false)
    @Enumerated(EnumType.ORDINAL)
    private Score score;

    /* 评论标题 */
    @Column(length=100, nullable=false)
    private String title;

    /* 评论正文 */
    @Column(length=500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ware ware;

    private Date forDate;
    
    public WareComment() {}

    public WareComment(String title) {
        this.title = title;
    }

    public WareComment(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Ware getWare() {
        return ware;
    }

    public void setWare(Ware ware) {
        this.ware = ware;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getForDate() {
        return forDate;
    }

    public void setForDate(Date forDate) {
        this.forDate = forDate;
    }

}
