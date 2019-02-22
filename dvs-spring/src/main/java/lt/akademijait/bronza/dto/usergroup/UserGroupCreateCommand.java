package lt.akademijait.bronza.dto.usergroup;

import lt.akademijait.bronza.entities.DocumentType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

public class UserGroupCreateCommand {


    @NotNull
    private String title;

    private Set<String> submitDocumentType;

    private Set<String> reviewDocumentType;


    public UserGroupCreateCommand() {
    }

    public UserGroupCreateCommand(@NotNull String title, Set<String> submitDocumentType, Set<String> reviewDocumentType) {
        this.title = title;
        this.submitDocumentType = submitDocumentType;
        this.reviewDocumentType = reviewDocumentType;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getSubmitDocumentType() {
        return submitDocumentType;
    }

    public void setSubmitDocumentType(Set<String> submitDocumentType) {
        this.submitDocumentType = submitDocumentType;
    }

    public Set<String> getReviewDocumentType() {
        return reviewDocumentType;
    }

    public void setReviewDocumentType(Set<String> reviewDocumentType) {
        this.reviewDocumentType = reviewDocumentType;
    }

}