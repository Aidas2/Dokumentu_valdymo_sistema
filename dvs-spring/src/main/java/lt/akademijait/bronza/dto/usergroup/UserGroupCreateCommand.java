package lt.akademijait.bronza.dto.usergroup;

import lt.akademijait.bronza.entities.DocumentType;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserGroupCreateCommand {

    private Long id;
//    private Long userGroupId;

    @NotNull
    private String title;
    private List<DocumentType> submissionDocumentType;
    private List<DocumentType> reviewDocumentType;


    public UserGroupCreateCommand() {
    }

    public UserGroupCreateCommand(Long id, @NotNull String title, List<DocumentType> submissionDocumentType, List<DocumentType> reviewDocumentType) {
        this.id = id;
        this.title = title;
        this.submissionDocumentType = submissionDocumentType;
        this.reviewDocumentType = reviewDocumentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DocumentType> getSubmissionDocumentType() {
        return submissionDocumentType;
    }

    public void setSubmissionDocumentType(List<DocumentType> submissionDocumentType) {
        this.submissionDocumentType = submissionDocumentType;
    }

    public List<DocumentType> getReviewDocumentType() {
        return reviewDocumentType;
    }

    public void setReviewDocumentType(List<DocumentType> reviewDocumentType) {
        this.reviewDocumentType = reviewDocumentType;
    }

}