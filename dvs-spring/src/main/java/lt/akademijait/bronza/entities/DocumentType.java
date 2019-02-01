package lt.akademijait.bronza.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
//@Table(name="DOCUMENT_TYPE")
//@Table(name="DOCUMENT_TYPE", uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    @ManyToMany
    private Set<UserGroup> submissionUserGroups;

    @ManyToMany
    private Set<UserGroup> reviewUserGroups;

    //Constructors:

    public DocumentType() {
    }

    public DocumentType(String title, Set<UserGroup> submissionUserGroups, Set<UserGroup> reviewUserGroups) {
        this.title = title;
        this.submissionUserGroups = submissionUserGroups;
        this.reviewUserGroups = reviewUserGroups;
    }

    //Getters and Setters:

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

    public Set<UserGroup> getSubmissionUserGroups() {
        return submissionUserGroups;
    }

    public void setSubmissionUserGroups(Set<UserGroup> submissionUserGroups) {
        this.submissionUserGroups = submissionUserGroups;
    }

    public Set<UserGroup> getReviewUserGroups() {
        return reviewUserGroups;
    }

    public void setReviewUserGroups(Set<UserGroup> reviewUserGroups) {
        this.reviewUserGroups = reviewUserGroups;
    }
}
