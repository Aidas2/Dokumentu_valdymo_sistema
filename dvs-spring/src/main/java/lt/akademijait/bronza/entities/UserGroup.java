package lt.akademijait.bronza.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(unique = true, nullable=false)
    //private Long userGroupId;

    @Column(unique = true, nullable = false)
    private String title;

    //Documents types that this group can submit
    @ManyToMany
    @JoinTable(name = "submission_type", joinColumns = @JoinColumn(name = "user_group"),
            inverseJoinColumns = @JoinColumn(name = "submission_type_id"))
    private Set<DocumentType> submissionDocumentType;


    //Documents types that this group can review
    @ManyToMany
    @JoinTable(name = "review_type", joinColumns = @JoinColumn(name = "user_group"),
            inverseJoinColumns = @JoinColumn(name = "review_type_id"))
    private Set<DocumentType> reviewDocumentType;

    public UserGroup() {

    }

    public UserGroup(String title, Set<DocumentType> submissionDocumentType, Set<DocumentType> reviewDocumentType) {
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

    public Set<DocumentType> getSubmissionDocumentType() {
        return submissionDocumentType;
    }

    public void setSubmissionDocumentType(Set<DocumentType> submissionDocumentType) {
        this.submissionDocumentType = submissionDocumentType;
    }

    public Set<DocumentType> getReviewDocumentType() {
        return reviewDocumentType;
    }

    public void setReviewDocumentType(Set<DocumentType> reviewDocumentType) {
        this.reviewDocumentType = reviewDocumentType;
    }
}
