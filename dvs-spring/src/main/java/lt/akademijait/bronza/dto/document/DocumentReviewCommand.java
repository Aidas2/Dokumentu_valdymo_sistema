package lt.akademijait.bronza.dto.document;

import lt.akademijait.bronza.entities.User;
import lt.akademijait.bronza.enums.DocumentState;

//this is experimental class, not necessary

public class DocumentReviewCommand {

    private User reviewer; //private String reviewerUsername;
    private String rejectionReason;
    private DocumentState documentState;


    public DocumentReviewCommand() {
    }

    //option 1
    /*
    public DocumentReviewCommand(User reviewer, String rejectionReason, DocumentState documentState) {
        this.reviewer = reviewer;
        this.rejectionReason = rejectionReason;
        this.documentState = documentState;
    }
    */

    //option 2
    public DocumentReviewCommand(User reviewer, String rejectionReason, String documentState) {
        this.reviewer = reviewer;
        this.rejectionReason = rejectionReason;
        this.documentState = DocumentState.valueOf(documentState);
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

    public DocumentState getDocumentState() {
        return documentState;
    }

    /*
    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }
    */

    public void setDocumentState(String documentState) {
        this.documentState = DocumentState.valueOf(documentState);
    }

}
