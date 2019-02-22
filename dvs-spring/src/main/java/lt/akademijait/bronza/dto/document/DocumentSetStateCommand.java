package lt.akademijait.bronza.dto.document;

import lt.akademijait.bronza.enums.DocumentState;

public class DocumentSetStateCommand {

    private Long documentId; //necessary when choosing which document to manage (in documentRepository you find document by id, therefore you should specify that id)
    //private List<String> additionalFilePaths = new ArrayList<>();
    //private List<Attachment> attachments;

    //private User author;
    //private String username;

    private DocumentState documentState;    //version_01
    //private String documentState;         //version_02 (by J.C.)

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

    public DocumentSetStateCommand(Long documentId, DocumentState documentState, String authorUsername, String reviewerUsername, String rejectionReason) {
        this.documentId = documentId;
        this.documentState = documentState;
        this.authorUsername = authorUsername;
        this.reviewerUsername = reviewerUsername;
        this.rejectionReason = rejectionReason;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
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
