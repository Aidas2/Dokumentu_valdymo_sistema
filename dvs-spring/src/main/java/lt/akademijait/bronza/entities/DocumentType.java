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
    //private String id;

    @Column(unique = true, nullable = false)
    private String title;

    @ManyToMany//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinTable(name = "submission_type", joinColumns = @JoinColumn(name="doc_type"), inverseJoinColumns = @JoinColumn(name="user_group_id") )
    private Set<UserGroup> submissionUserGroups;

    @ManyToMany//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinTable(name = "review_type", joinColumns = @JoinColumn(name="doc_type"), inverseJoinColumns = @JoinColumn(name="user_group_id") )
    private Set<UserGroup> reviewUserGroups;


    //Constructors:

    public DocumentType() {
    }

    public DocumentType(String title,
                        Set<UserGroup> submissionUserGroups,
                        Set<UserGroup> reviewUserGroups) {
        this.title = title;
        this.submissionUserGroups = submissionUserGroups;
        this.reviewUserGroups = reviewUserGroups;
    }

/*
    //SUBMISSION GROUP - TYPE (ADD REMOVE)
    public void addSubmissionUserGroup(UserGroup userGroup) {
        submissionUserGroups.add(userGroup);
    }
    public void removeSubmissionUserGroup(UserGroup userGroup) {
        submissionUserGroups.remove(userGroup);
    }
    //REVIEW GROUP - TYPE (ADD REMOVE)
    public void addReviewUserGroup(UserGroup userGroup) {
        reviewUserGroups.add(userGroup);
    }

    public void removeReviewUserGroup(UserGroup userGroup) {
        reviewUserGroups.remove(userGroup);
    }
*/

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
