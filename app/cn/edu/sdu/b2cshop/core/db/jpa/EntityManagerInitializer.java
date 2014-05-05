package cn.edu.sdu.b2cshop.core.db.jpa;


/**
 * Initialize an EntityManager after it is created
 * 
 * @author Peter Fu
 */
public interface EntityManagerInitializer {

    void initialize();

}
