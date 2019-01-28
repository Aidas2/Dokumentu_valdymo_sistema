package lt.akademijait.bronza.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    //@Column(unique = true, nullable=false)
    //private String userGroupId;

    @Column(unique = true, nullable=false)
    private String title;

    //Documents types that this group can submit
    @ManyToMany
    @JoinTable(name = "submission_type", joinColumns = @JoinColumn(name = "user_group"),
    inverseJoinColumns = @JoinColumn(name="submission_type_id"))
    private List<DocType> submissionDocType;


    //Documents types that this group can review
    @ManyToMany
    @JoinTable(name = "review_type", joinColumns = @JoinColumn(name="user_group"),
            inverseJoinColumns = @JoinColumn(name="review_type_id"))
    private List<DocType> reviewDocType;

    public UserGroup() {

    }

    public UserGroup(@NotNull String title, List<DocType> submissionDocType, List<DocType> reviewDocType) {
        this.title = title;
        this.submissionDocType = submissionDocType;
        this.reviewDocType = reviewDocType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
