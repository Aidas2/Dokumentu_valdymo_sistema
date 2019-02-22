package lt.akademijait.bronza.dto.document;

public class DocumentSetStateCommand {

    private Long documentId; //necessary when choosing which document to manage (in documentRepository you find document by id, therefore you should specify that id)
    //private List<String> additionalFilePaths = new ArrayList<>();
    //private List<Attachment> attachments;
    //private String username;    //private User author;
    private String documentState;
    //private DocumentType documentType;
    //private String title;
    //private String description;
    //private Date creationDate;
    //private Date submissionDate;
    //private Date confirmationDate;
    //private Date rejectionDate;
    private String authorUsername;
    private String reviewerUsername;    //private User reviewer;
    private String rejectionReason;

    public DocumentSetStateCommand() {
    }

    public DocumentSetStateCommand(Long documentId, String documentState, String authorUsername, String reviewerUsername, String rejectionReason) {
        this.documentId = documentId;
        this.documentState = documentState;
        this.authorUsername = authorUsername;
        this.reviewerUsername = reviewerUsername;
        this.rejectionReason = rejectionReason;
    }


    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentState() {
        return documentState;
    }

    public void setDocumentState(String documentState) {
        this.documentState = documentState;
    }

//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public Date getSubmissionDate() {
//        return submissionDate;
//    }
//
//    public void setSubmissionDate(Date submissionDate) {
//        this.submissionDate = submissionDate;
//    }
//
//    public Date getConfirmationDate() {
//        return confirmationDate;
//    }
//
//    public void setConfirmationDate(Date confirmationDate) {
//        this.confirmationDate = confirmationDate;
//    }
//
//    public Date getRejectionDate() {
//        return rejectionDate;
//    }
//
//    public void setRejectionDate(Date rejectionDate) {
//        this.rejectionDate = rejectionDate;
//    }

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
