package lt.akademijait.bronza.dto.document;

import lt.akademijait.bronza.entities.DocType;
import lt.akademijait.bronza.entities.User;

public class DocCreateCommand {

//    private Long id;
    private User author;
    private DocType docType;
//    private DocState docState;
    private String title;
    private String description;
//    private LocalDate creationDate;
//    private LocalDate submissionDate;
//    private LocalDate confirmationDate;
//    private LocalDate rejectionDate;
//    private User reviewer;
//    private String rejectionReason;
//    private List<Attachment> attachments;
//    private String path;


    public DocCreateCommand(User author) {
    }

    public DocCreateCommand(User author, DocType docType, String title, String description) {
        this.author = author;
        this.docType = docType;
        this.title = title;
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
