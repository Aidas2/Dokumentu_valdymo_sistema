package lt.akademijait.bronza.dto.usergroup;

import lt.akademijait.bronza.entities.DocType;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UserGroupCreateCommand {

//    private Long id;
//    private Long userGroupId;

    @NotNull
    private String title;

    private List<DocType> submissionDocType;
    private List<DocType> reviewDocType;


    public UserGroupCreateCommand() {
    }

    public UserGroupCreateCommand(@NotNull String title, List<DocType> submissionDocType, List<DocType> reviewDocType) {
        this.title = title;
        this.submissionDocType = submissionDocType;
        this.reviewDocType = reviewDocType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DocType> getSubmissionDocType() {
        return submissionDocType;
    }

    public void setSubmissionDocType(List<DocType> submissionDocType) {
        this.submissionDocType = submissionDocType;
    }

    public List<DocType> getReviewDocType() {
        return reviewDocType;
    }

    public void setReviewDocType(List<DocType> reviewDocType) {
        this.reviewDocType = reviewDocType;
    }
}