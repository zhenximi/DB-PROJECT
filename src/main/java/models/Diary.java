package models;

/**
 * Created by Tom on 16/4/24.
 */

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
public class Diary {
    private Long id;
    private UserTable author;
    private String title;
    private String content;
    private Timestamp timestamp;

    public Diary(UserTable author, String content, String title, Timestamp timestamp){
        this.author=author;
        this.content=content;
        this.title=title;
        this.timestamp=timestamp;
    }
    public Diary(){}

    @Id
    @GeneratedValue
    @Column(name = "diary_id")
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
    public String getContent() {
        return content;
    }



    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle(){ return title;}

    public void setTitle(String title){this.title=title;}

    /**
     * @return the timestamp
     */
    public Timestamp getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
