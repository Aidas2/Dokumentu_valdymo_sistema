package lt.akademijait.bronza.dto.usergroup;

import lt.akademijait.bronza.entities.DocumentType;

import java.util.Set;

public class UserGroupGetCommand {

//    private Long id;
//    private Long userGroupId;

    private String title;
    private Set<String> submissionDocType;
    private Set<String> reviewDocType;


    public UserGroupGetCommand() {
    }

    public UserGroupGetCommand(String title, Set<String> submissionDocType, Set<String> reviewDocType) {
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

    public Set<String> getSubmissionDocType() {
        return submissionDocType;
    }

    public void setSubmissionDocType(Set<String> submissionDocType) {
        this.submissionDocType = submissionDocType;
    }

    public Set<String> getReviewDocType() {
        return reviewDocType;
    }

    public void setReviewDocType(Set<String> reviewDocType) {
        this.reviewDocType = reviewDocType;
    }
}
