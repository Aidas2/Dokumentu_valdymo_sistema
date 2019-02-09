package lt.akademijait.bronza.dto.document;

public class DocumentCreateCommand {

//    private Long id;
    //private String prefix;
    //private List<String> additionalFilePaths = new ArrayList<>();
    //private List<Attachment> attachments;
    //private User author; // do not use object, because object sends to swagger all his fields
    private String usernameId;
    //private DocumentState documentState;
    //private DocumentType documentType; // do not use object, because object sends to swagger all his fields
    private Long documentTypeId;
    private String title;
    private String description;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//private Date creationDate;
    //private Date submissionDate;
    //private Date confirmationDate;
    //private Date rejectionDate;
    //private User reviewer;
    //private String rejectionReason;
    //private String path;


    public DocumentCreateCommand() {
    }

    public DocumentCreateCommand(String usernameId, Long documentTypeId, String title, String description) {
        this.usernameId = usernameId;
        this.documentTypeId = documentTypeId;
        this.title = title;
        this.description = description;
    }

    public String getUsernameId() {
        return usernameId;
    }

    public void setUsernameId(String usernameId) {
        this.usernameId = usernameId;
    }

    public Long getDocumentTypeTitle() {
        return documentTypeId;
    }

    public void setDocumentTypeTitle(Long documentTypeTitle) {
        this.documentTypeId = documentTypeTitle;
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
