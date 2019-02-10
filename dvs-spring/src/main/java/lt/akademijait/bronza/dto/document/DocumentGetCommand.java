package lt.akademijait.bronza.dto.document;


import lt.akademijait.bronza.entities.DocumentType;
import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.enums.DocumentState;

import java.util.Date;

public class DocumentGetCommand {

    private Long id;
    //private String prefix;
    //private List<String> additionalFilePaths = new ArrayList<>();
    //private List<Attachment> attachments;
    private Long authorId; // private UserGetCommand author;
    private DocumentState documentState;
    private Long documentTypeId; //private String documentTypeTitle;
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

    public DocumentGetCommand(Long authorId, DocumentState documentState, Long documentTypeId, String title, String description, Date creationDate, Date submissionDate, Date confirmationDate, Date rejectionDate, User reviewer, String rejectionReason, String path) {
        this.authorId = authorId;
        this.documentState = documentState;
        this.documentTypeId = documentTypeId;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
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
