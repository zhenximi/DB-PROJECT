package dao;

/**
 * Created by Tom on 16/4/29.
 */

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.persist.Transactional;
import models.*;
import models.UserTable;

public class ProfileDao {

    @Inject
    Provider<EntityManager> EntityManagerProvider;

    @Transactional
    public Profile getProfileFromUser(Long profile_id) {
        List<Profile> result = new ArrayList<>();
        EntityManager em = EntityManagerProvider.get();
        Query q = em.createQuery("SELECT x FROM Profile x WHERE profile_id =:profileid");
        q.setParameter("profileid", profile_id);
        result = (List<Profile>) q.getResultList();
        if(result.size() ==1) {
            return result.get(0);
        }
        return null;
    }


    @Transactional
    public Profile getProfileFromProfile(UserTable targetUser) {
        List<Profile> result = new ArrayList<>();
        EntityManager em = EntityManagerProvider.get();
        Query q = em.createQuery("SELECT x FROM Profile x WHERE author =:targetuser");
        q.setParameter("targetuser", targetUser);
        result = (List<Profile>) q.getResultList();
        if(result.size() ==1) {
            return result.get(0);
        }
        return null;
    }





}
