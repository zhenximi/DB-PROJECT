

package dao;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.inject.persist.Transactional;
import models.Post;
import models.UserTable;
import models.UserTable;

public class PostDao {
    @Inject
    Provider<EntityManager> EntityManagerProvider;
    
    public List<Post> getPostsFromUsers(List<UserTable> userlist) {
        EntityManager em = EntityManagerProvider.get();
        List<Post> result = new ArrayList<>();
        
        String strQuery = "SELECT x FROM Post x WHERE user_id IN (";
        for (int i = 0; i < userlist.size(); i++) {
            strQuery += "'" + userlist.get(i).getId() + "'";
            if(i != userlist.size() - 1)
                strQuery += ", ";
        }
        strQuery += ") ORDER BY timestamp DESC";
        // Get all post from user's relatives posts
        Query q = em.createQuery(strQuery);
        result = (List<Post>) q.getResultList();
        
        return result;
    }
    @Transactional
    public Post getPostFromSearchResult(Long post_id) {
        List<Post> result = new ArrayList<>();
        EntityManager em = EntityManagerProvider.get();
        Query q = em.createQuery("SELECT x FROM Post x WHERE post_id =:postid");
        q.setParameter("postid", post_id);
        result = (List<Post>) q.getResultList();
        if(result.size() ==1) {
            return result.get(0);
        }
        return null;
    }
    @Transactional
    public List<Post> getPostFromKeyword(String content) {
        List<Post> result = new ArrayList<>();
        EntityManager em = EntityManagerProvider.get();
        Query q = em.createQuery("SELECT x FROM Post x WHERE content LIKE :keyword");
        q.setParameter("keyword", "%" + content + "%");
        result = (List<Post>) q.getResultList();
        //System.out.println("+++++++++++++++++++++++++++search result: " + result.size());
        return result;
    }
}

