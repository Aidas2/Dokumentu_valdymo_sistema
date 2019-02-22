package lt.akademijait.bronza.dto.usergroup;

import lt.akademijait.bronza.entities.DocumentType;

import java.util.Set;

public class UserGroupGetCommand {

//    private Long id;
//    private Long userGroupId;

    private String title;

    private Set<DocumentType> submissionDocType;
    private Set<DocumentType> reviewDocType;


    public UserGroupGetCommand() {
    }

    public UserGroupGetCommand(String title, Set<DocumentType> submissionDocType, Set<DocumentType> reviewDocType) {
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

    public Set<DocumentType> getSubmissionDocType() {
        return submissionDocType;
    }

    public void setSubmissionDocType(Set<DocumentType> submissionDocType) {
        this.submissionDocType = submissionDocType;
    }

    public Set<DocumentType> getReviewDocType() {
        return reviewDocType;
    }

    public void setReviewDocType(Set<DocumentType> reviewDocType) {
        this.reviewDocType = reviewDocType;
    }
}
