package lt.akademijait.bronza.dto.usergroup;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class UserGroupUpdateCommand {
    @NotNull
    @Length(min = 4)
    private String title;

    private Set<String> submitDocumentType;

    private Set<String> reviewDocumentType;

    public UserGroupUpdateCommand() {
    }

    public UserGroupUpdateCommand(@NotNull @Length(min = 4) String title,
                                  Set<String> submitDocumentType, Set<String> reviewDocumentType) {
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
