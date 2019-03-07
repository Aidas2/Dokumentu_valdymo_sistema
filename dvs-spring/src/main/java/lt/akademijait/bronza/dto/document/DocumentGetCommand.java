package lt.akademijait.bronza.dto.document;


import lt.akademijait.bronza.entities.Attachment;
import lt.akademijait.bronza.enums.DocumentState;

import java.util.Date;
import java.util.Set;

public class DocumentGetCommand {

    private Long id;
    //private String prefix;
    //private List<String> additionalFilePaths = new ArrayList<>();

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
    private String reviewerUsername;    //private User reviewer; //private UserGetCommand reviewer;
    private String rejectionReason;
    private String path;

    private Set<Attachment> attachments;


    public DocumentGetCommand() {
    }

    public DocumentGetCommand(Long id, String authorUsername, String documentState,
                              String documentTypeTitleInLithuanian, String title, String description,
                              Date creationDate, Date submissionDate, Date confirmationDate, Date rejectionDate,
                              String reviewerUsername, String rejectionReason, String path, Set<Attachment> attachments) {
        this.id = id;
        this.authorUsername = authorUsername;
        //this.documentStateInLithuanian = documentStateInLithuanian; //see remark bellow
        this.documentStateInLithuanian = setDocumentStateInLithuanian(documentState);//its is not enough to do validation in setter, also this validation must be in constructor
        this.documentTypeTitleInLithuanian = documentTypeTitleInLithuanian;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.submissionDate = submissionDate;
        this.confirmationDate = confirmationDate;
        this.rejectionDate = rejectionDate;
        this.reviewerUsername = setReviewerUsername(reviewerUsername);
        this.rejectionReason = setRejectionReason(rejectionReason);
        this.path = path;
        this.attachments = attachments;
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

    public String setDocumentStateInLithuanian(String documentState) {


        if (documentState.equals(DocumentState.CREATED.toString())) {
            return "SUKURTAS";
        } else if (documentState.equals(DocumentState.SUBMITTED.toString())) {
            return "PATEIKTAS";
        } else if (documentState.equals(DocumentState.CONFIRMED.toString())) {
            return "PATVIRTINTAS";
        } else if (documentState.equals(DocumentState.REJECTED.toString())) {
            return "ATMESTAS";
        } else {
            return documentState.toString();
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

    public String getReviewerUsername() {
        return reviewerUsername;
    }

    public String setReviewerUsername(String reviewerUsername) {
        if(reviewerUsername == null) {
            this.reviewerUsername = "";
        } else {
            this.reviewerUsername = reviewerUsername;
        }
        return this.reviewerUsername;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public String setRejectionReason(String rejectionReason) {
        if(rejectionReason == null) {
            this.rejectionReason = "";
        } else {
            this.rejectionReason = rejectionReason;
        }
        return this.rejectionReason;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }
}
