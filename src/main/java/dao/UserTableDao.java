package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.UserTable;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import etc.Globals;

import java.util.ArrayList;
import java.util.List;

import models.UserTable;
import models.User_session;
import ninja.Context;

public class UserTableDao {
    @Inject
    Provider<EntityManager> EntityManagerProvider;

    @Transactional
    public UserTable canLogin(String email, String password) {
        if(email != null && password != null) {
            EntityManager em = EntityManagerProvider.get();

            Query q = em.createQuery("SELECT x FROM UserTable x WHERE  email = :emailParam");
            List<UserTable> user = (List<UserTable>) q.setParameter("emailParam", email).getResultList();
            System.out.println("user:" + user.get(0).getEmail());

            if(user.size() == 1) {
                System.out.println("test size");
                System.out.println("database: " + user.get(0).getPassword());
                System.out.println("parameter: " + password);
                if(user.get(0).getPassword().equals(password)) {
                    System.out.println("test password");
                    return user.get(0);
                }
            }
        }
        return null;
    }

    @Transactional
    public UserTable getUserFromSession(Context context) {
        EntityManager em = EntityManagerProvider.get();

        Query q = em.createQuery("SELECT x FROM User_session x WHERE id='" + context.getSession().get(Globals.CookieSession) + "'");
        User_session uSession = (User_session) q.getSingleResult();

        return uSession.getUser();
    }

    @Transactional
    public UserTable getUserFromUsername(String username) {
        EntityManager em = EntityManagerProvider.get();

        Query q = em.createQuery("SELECT x FROM UserTable x WHERE username = :target");
        q.setParameter("target", username);
        List<UserTable> result = q.getResultList();

        if(result.size() == 1) {
            return result.get(0);
        }
        return null;
    }
    @Transactional
    public List<UserTable> getUserListFromKeyword(String full_name) {
        List<UserTable> result = new ArrayList<>();
        EntityManager em = EntityManagerProvider.get();
        Query q = em.createQuery("SELECT x FROM UserTable x WHERE full_name LIKE :keyword");
        q.setParameter("keyword", "%" + full_name + "%");
        result = (List<UserTable>) q.getResultList();
        //System.out.println("+++++++++++++++++++++++++++search result: " + result.size());
        return result;
    }
}
