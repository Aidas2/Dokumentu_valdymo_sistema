package lt.akademijait.bronza.entities;

import javax.persistence.*;

//this is experimental class, not necessary

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

    /*
    @ManyToOne//(mappedBy="attachments")
    //@JoinColumn (name = "DOCUMENT_ID")
    private Document document;
    */

    //Constructors:

    public Attachment() {
    }

    public Attachment(Long id, String title, String path) {
        this.id = id;
        this.title = title;
        this.path = path;
    }

    //Getters and Setters:


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


/* TODO LIST:
nevalina metodas: READ All DOCUMENTS OF SPECIFIC DOCUMENT_TYPE. Version_01 (object; @PathVariable)
Pakoreguoti metoda: SET DOCUMENT STATE. Version_01 (by my)  ir SET DOCUMENT STATE. Version_02 (by J.C.)

Validacija laukams (@Valid)
Klaidu handlinimas  + loggeriai klaidoms
Loggeriai su data + kad irasytu i faila - COMPLEETED

lithuanian enum doesn't works correctly - COMPLEETED


        //papildyti kad jeigu neranda DocumentType tai reikia handlint errora
        // (pvz. iseiti is metodo, arba responseEntity arba ResourceNotFoundException)
        // nes priesingu atveju programa nulus.




 */