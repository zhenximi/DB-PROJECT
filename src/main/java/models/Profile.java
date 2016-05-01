package models;

/**
 * Created by Tom on 16/4/24.
 */

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
public class Profile {
    private Long id;
    private UserTable author;
    private String birthday;
    private String gender;
    private String hobby;
    //private String personal;


    public Profile(UserTable author, String birthday, String gender, String hobby){
        this.author=author;
        this.birthday=birthday;
        this.gender=gender;
        this.hobby=hobby;
        //this.personal=personal;
    }
    public Profile(){}

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "profile_id")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the author
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public UserTable getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(UserTable author) {
        this.author = author;
    }


    /**
     * @return the content
     */
    public String getBirthday() {
        return birthday;
    }




    public void   setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender(){ return gender;}

    public void setGender(String gender){this.gender=gender;}

    /**
     * @return the timestamp
     */
    public String  getHobby() {
        return hobby;
    }


    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

   /* public String getAboutme(String aboutme) {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme=aboutme;
    }*/

}
