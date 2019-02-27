package lt.akademijait.bronza.dto.document;


import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.enums.DocumentState;

import java.util.Date;

public class DocumentGetCommand {

    private Long id;
    //private String prefix;
    //private List<String> additionalFilePaths = new ArrayList<>();
    //private List<Attachment> attachments;
    private String authorUsername;  //private User author; // private UserGetCommand author;\

    private String documentStateInLithuanian;
    //private DocumentState documentState;

    private String documentTypeTitleInLithuanian; //private DocumentType documentType;
    private String title;
    private String description;
    private Date creationDate;
    private Date submissionDate;
    private Date confirmationDate;
    private Date rejectionDate;
    private User reviewer; //private UserGetCommand reviewer;
    private String rejectionReason;
    private String path;

    public DocumentGetCommand() {
    }


// constructior with double Document_State
    public DocumentGetCommand(Long id, String authorUsername, String documentStateInLithuanian, String documentTypeTitleInLithuanian, String title, String description, Date creationDate, Date submissionDate, Date confirmationDate, Date rejectionDate, User reviewer, String rejectionReason, String path) {
        this.id = id;
        this.authorUsername = authorUsername;
        //this.documentStateInLithuanian = documentStateInLithuanian; //see remark bellow
        setDocumentStateInLithuanian(documentStateInLithuanian);//its is not enough to do validation in setter, also this validation must be in constructor
        this.documentTypeTitleInLithuanian = documentTypeTitleInLithuanian;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.submissionDate = submissionDate;
        this.confirmationDate = confirmationDate;
        this.rejectionDate = rejectionDate;
        this.reviewer = reviewer;
        this.rejectionReason = rejectionReason;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public String getDocumentStateInLithuanian() {
        return documentStateInLithuanian;
    }

    public void setDocumentStateInLithuanian(String documentStateInLithuanian) {
        if (documentStateInLithuanian.equals(DocumentState.CREATED)) {
            this.documentStateInLithuanian = "SUKURTAS";
        } else if (documentStateInLithuanian.equals(DocumentState.SUBMITTED)) {
            this.documentStateInLithuanian = "PATEIKTAS";
        } else if (documentStateInLithuanian.equals(DocumentState.CONFIRMED)) {
            this.documentStateInLithuanian = "PATVIRTINTAS";
        } else if (documentStateInLithuanian.equals(DocumentState.REJECTED)) {
            this.documentStateInLithuanian = "ATMESTAS";
        } else {
            this.documentStateInLithuanian = documentStateInLithuanian;
        }
    }

    public String getDocumentTypeTitleInLithuanian() {
        return documentTypeTitleInLithuanian;
    }

    public void setDocumentTypeTitleInLithuanian(String documentTypeTitleInLithuanian) {
        this.documentTypeTitleInLithuanian = documentTypeTitleInLithuanian;
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Date getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(Date rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
