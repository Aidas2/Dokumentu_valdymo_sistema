package lt.akademijait.bronza.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class UserGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @NotNull
    private String title;


    @ManyToMany
    @JoinTable(name = "submission_type", joinColumns = @JoinColumn(name = "user_group"),
    inverseJoinColumns = @JoinColumn(name="submission_type_id"))
    private List<DocType> submittedDocType;


    @ManyToMany
    @JoinTable(name = "review_type", joinColumns = @JoinColumn(name="user_group"),
            inverseJoinColumns = @JoinColumn(name="review_type_id"))
    private List<DocType> reviewedDocType;

}
