package lt.akademijait.bronza.dto.usergroup;

import lt.akademijait.bronza.entities.DocumentType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class UserGroupCreateCommand {


    @NotNull
    private String title;

    private Set<String> documentType;
//    private List<DocumentType> reviewDocumentType;


    public UserGroupCreateCommand() {
    }

    public UserGroupCreateCommand(@NotNull String title, Set<String> documentType) {
        this.title = title;
        this.documentType = documentType;
//        this.reviewDocumentType = reviewDocumentType;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Set<String> documentType) {
        this.documentType = documentType;
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