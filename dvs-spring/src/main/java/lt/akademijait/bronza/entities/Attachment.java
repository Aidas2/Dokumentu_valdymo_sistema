package lt.akademijait.bronza.entities;

import javax.persistence.*;

@Entity
@Table(name="ATTACHMENT")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String path;


    public Attachment() {
    }

    public Attachment(/*Long id,*/ String title, String path) {
//        this.id = id;
        this.title = title;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
