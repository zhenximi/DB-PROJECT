package models;

import javax.persistence.*;

@Entity
public class Relationship {
    private Long id;
    private UserTable user_a;
    private UserTable user_b;
    private int relation_type;

    public Relationship() {}

    public Relationship(UserTable user_a, UserTable user_b, int relation_type) {
        this.user_a = user_a;
        this.user_b = user_b;
        this.relation_type = relation_type;
    }

    /**
     * @return the id
     */
    @Id
    @Column(name = "relation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the user_a
     */
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_a", referencedColumnName = "user_id")
    public UserTable getUser_a() {
        return user_a;
    }

    /**
     * @param user_a the user_a to set
     */
    public void setUser_a(UserTable user_a) {
        this.user_a = user_a;
    }

    /**
     * @return the user_b
     */
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_b", referencedColumnName = "user_id")
    public UserTable getUser_b() {
        return user_b;
    }

    /**
     * @param user_b the user_b to set
     */
    public void setUser_b(UserTable user_b) {
        this.user_b = user_b;
    }

    /**
     * @return the relation_type
     */
    public int getRelation_type() {
        return relation_type;
    }

    /**
     * @param relation_type the relation_type to set
     */
    public void setRelation_type(int relation_type) {
        this.relation_type = relation_type;
    }
}