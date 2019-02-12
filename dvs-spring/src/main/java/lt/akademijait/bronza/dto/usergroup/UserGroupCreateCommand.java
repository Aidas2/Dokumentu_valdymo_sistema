package lt.akademijait.bronza.dto.usergroup;

import lt.akademijait.bronza.entities.DocumentType;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserGroupCreateCommand {


    @NotNull
    private String title;
//    private List<DocumentType> submissionDocumentType;
//    private List<DocumentType> reviewDocumentType;


    public UserGroupCreateCommand() {
    }

    public UserGroupCreateCommand(@NotNull String title) {
        this.title = title;
//        this.submissionDocumentType = submissionDocumentType;
//        this.reviewDocumentType = reviewDocumentType;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public List<DocumentType> getSubmissionDocumentType() {
//        return submissionDocumentType;
//    }
//
//    public void setSubmissionDocumentType(List<DocumentType> submissionDocumentType) {
//        this.submissionDocumentType = submissionDocumentType;
//    }
//
//    public List<DocumentType> getReviewDocumentType() {
//        return reviewDocumentType;
//    }
//
//    public void setReviewDocumentType(List<DocumentType> reviewDocumentType) {
//        this.reviewDocumentType = reviewDocumentType;
//    }

}