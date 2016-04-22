package models;

import javax.persistence.*;

@Entity
public class User_session {
    private String id;
    private UserTable user;
    //public Timestamp last_join;
    
    public User_session() {}

    public User_session(UserTable user) {
        this.user = user;
    }

    /**
     * @return the id
     */
    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public UserTable getUser() {
        return user;
    }

    public void setUser(UserTable user) {
        this.user = user;
    }
}
