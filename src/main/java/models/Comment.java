package models;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
public class Comment {
    private Long id;
    private UserTable author;
    private Long post_id;
    private String content;
    private Timestamp timestamp;

    public Comment() {}

    public Comment(UserTable author, Long post_id, String content, Timestamp timestamp) {
        this.author = author;
        this.post_id = post_id;
        this.content = content;
        this.timestamp = timestamp;
    }

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public UserTable getAuthor() {
        return author;
    }

    public void setAuthor(UserTable author) {
        this.author = author;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

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
