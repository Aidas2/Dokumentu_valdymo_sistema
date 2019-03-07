package lt.akademijait.bronza.dto.document;

import org.hibernate.validator.constraints.Length;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class DocumentCreateCommand {

    //private Long id;
    //private String prefix;
    //private List<String> additionalFilePaths = new ArrayList<>();

    //private Set<Attachment> attachments;
    @OneToMany
    private Set<String> attachmentTitle;


    //private User author; // do not use object, because object sends to swagger all his fields

    @NotNull
    @Length(min = 1, max = 30)
    private String username;
    //private DocumentState documentState;
    //private DocumentType documentType; // do not use object, because object sends to swagger all his fields

    @NotNull
    @Length(min = 1, max = 30)
    private String documentTypeTitle;

    @NotNull
    @Length(min = 1, max = 50)
    private String title;

    @NotNull
    @Length(min = 1, max = 500)
    private String description;
    //private Date creationDate;
    //private Date submissionDate;
    //private Date confirmationDate;
    //private Date rejectionDate;
    //private User reviewer;
    //private String rejectionReason;
    //private String path;



    public DocumentCreateCommand() {
    }

    public DocumentCreateCommand(String username, String documentTypeTitle, String title, String description) {
        this.username = username;
        this.documentTypeTitle = documentTypeTitle;
        this.title = title;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDocumentTypeTitle() {
        return documentTypeTitle;
    }

    public void setDocumentTypeTitle(String documentTypeTitle) {
        this.documentTypeTitle = documentTypeTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
