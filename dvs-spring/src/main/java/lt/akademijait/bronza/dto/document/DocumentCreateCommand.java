package lt.akademijait.bronza.dto.document;

import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.User;

public class DocumentCreateCommand {

    //private Long id;
    //private String prefix;
    //private List<String> additionalFilePaths = new ArrayList<>();
    //private List<Attachment> attachments;
    private User author; // private String username;
    //private DocumentState documentState;
    private DocumentType documentType; //private String documentTypeTitle;
    private String title;
    private String description;
    //private Date creationDate;
    //private Date submissionDate;
    //private Date confirmationDate;
    //private Date rejectionDate;
    //private User reviewer;
    //private String rejectionReason;
    //private String path;


    public DocumentCreateCommand() {
    }

    public DocumentCreateCommand(User author, DocumentType documentType, String title, String description) {
        this.author = author;
        this.documentType = documentType;
        this.title = title;
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
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
