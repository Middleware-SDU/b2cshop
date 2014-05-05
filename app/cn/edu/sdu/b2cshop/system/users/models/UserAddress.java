package cn.edu.sdu.b2cshop.system.users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import cn.edu.sdu.b2cshop.system.commons.BaseModel;

@Entity
public class UserAddress extends BaseModel {

    private static final long serialVersionUID = 1376033093804884891L;

    /* 地址名称 */
    @Column(length=10, nullable=false)
    private String addressName;

    /* 地址 */
    @Column(length=200, nullable=false)
    private String address;

    /* 地区 */
    @Column(length=30, nullable=false)
    private String area;

    /* 邮编 */
    @Column(length=10, nullable=false)
    private String zipCode;

    /* 电话 */
    @Column(length=30, nullable=false)
    private String telephone;

    /* 手机 */
    @Column(length=30, nullable=false)
    private String cellPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public UserAddress() {}

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
