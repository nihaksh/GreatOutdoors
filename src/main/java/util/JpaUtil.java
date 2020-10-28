
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class JpaUtil {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(ProjectConstants.PERSISTENEUNIT_NAME);

    private EntityManager entityManager;

    private JpaUtil() {

    }

    private static JpaUtil instance = new JpaUtil();

    public static JpaUtil getInstance() {
        return instance;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public void close() {
        entityManager.close();
        emf.close();
    }
}



