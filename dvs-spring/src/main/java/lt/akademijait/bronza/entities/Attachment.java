package lt.akademijait.bronza.entities;

import javax.persistence.*;

@Entity
@Table(name="ATTACHMENT")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String path;

    @ManyToOne//(mappedBy="attachments")
    //@JoinColumn (name = "DOCUMENT_ID")
    private Document document;

    //Constructors:

    protected Attachment() {
    }

    //Getters and Setters:

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }

    public Document getDocument() {
        return document;
    }
}
