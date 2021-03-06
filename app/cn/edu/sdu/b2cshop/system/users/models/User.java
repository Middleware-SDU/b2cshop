package cn.edu.sdu.b2cshop.system.users.models;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import cn.edu.sdu.b2cshop.system.commons.BaseModel;
import cn.edu.sdu.b2cshop.system.users.daos.UserDAO;
import cn.edu.sdu.b2cshop.system.users.daos.impls.UserDAOImpl;

@Entity
public class User extends BaseModel {

    private static final long serialVersionUID = -3717064118975224892L;

    @Column(length=10, nullable=false)
    private String username;

    @Column(length=8, nullable=false)
    private String password;

    @Column(length=10, nullable=false)
    private String realname;

    @Column(nullable=false)
    private boolean admin;

    @OneToMany(mappedBy = "user", cascade = { CascadeType.REMOVE }, targetEntity = UserAddress.class)
    private List<UserAddress> addresses = new ArrayList<UserAddress>();

    /**
     * Generic DAO for User model
     */
    public static UserDAO dao = new UserDAOImpl();

    public User() {}

    public User(String username) {
        this.username = username;
        this.admin = false;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.admin = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public List<UserAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<UserAddress> addresses) {
        this.addresses = addresses;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    /**
     * Add address to addresses
     * @param address : to add
     * @return whether add address successfully
     */
    public boolean addAddress(UserAddress address) {
        if(this.addresses != null && !this.addresses.contains(address)) {
            this.addresses.add(address);
            return true;
        }
        return false;
    }

    /**
     * Remove giving address from addresses. 
     * @param address : to remove from addresses
     */
    public void removeAddress(UserAddress address) {
        if(this.addresses != null && this.addresses.contains(address)) {
            this.addresses.remove(address);
        }
    }

}
