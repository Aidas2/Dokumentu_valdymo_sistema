package lt.akademijait.bronza.dto.document;

import lt.akademijait.bronza.enums.DocumentState;

import java.util.Date;

public class DocumentSetStateCommand {

    //private Long id;
    //private List<String> additionalFilePaths = new ArrayList<>();
    //private List<Attachment> attachments;
    //private String username;    //private User author;
    private DocumentState documentState;
    //private DocumentType documentType;
    //private String title;
    //private String description;
    private Date creationDate;
    private Date submissionDate;
    private Date confirmationDate;
    private Date rejectionDate;
    private String reviewerUsername;    //private User reviewer;
    private String rejectionReason;

    public DocumentSetStateCommand() {
    }

    public DocumentSetStateCommand(DocumentState documentState, Date creationDate, Date submissionDate, Date confirmationDate, Date rejectionDate, String reviewerUsername, String rejectionReason) {
        this.documentState = documentState;
        this.creationDate = creationDate;
        this.submissionDate = submissionDate;
        this.confirmationDate = confirmationDate;
        this.rejectionDate = rejectionDate;
        this.reviewerUsername = reviewerUsername;
        this.rejectionReason = rejectionReason;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
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

    public void setReviewerUsername(String reviewerUsername) {
        this.reviewerUsername = reviewerUsername;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}
