package lt.akademijait.bronza.dto.usergroup;

import lt.akademijait.bronza.entities.DocumentType;

import java.util.Set;

public class UserGroupGetCommand {

//    private Long id;
//    private Long userGroupId;

    private String title;

    private Set<DocumentType> submissionDocType;
//    private List<DocType> reviewDocType;


    public UserGroupGetCommand() {
    }

    public UserGroupGetCommand(String title, Set<DocumentType> submissionDocType) {
        this.title = title;
        this.submissionDocType = submissionDocType;
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
}
