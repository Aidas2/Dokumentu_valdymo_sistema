package lt.akademijait.bronza.entities;

import javax.persistence.*;

@Entity
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //private String id;

    @Column(unique = true, nullable = false)
    private String title;


    public DocumentType() {
    }

    public DocumentType(String title) {
        this.title = title;
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

}
