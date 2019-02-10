package lt.akademijait.bronza.dto.document;

public class DocumentCreateCommand {

//    private Long id;
    //private String prefix;
    //private List<String> additionalFilePaths = new ArrayList<>();
    //private List<Attachment> attachments;
    //private User author; // do not use object, because object sends to swagger all his fields
    private String authorId;
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

    public DocumentCreateCommand(String authorId, Long documentTypeId, String title, String description) {
        this.authorId = authorId;
        this.documentTypeId = documentTypeId;
        this.title = title;
        this.description = description;
    }

    public String getAuthoId() {
        return authorId;
    }

    public void setAuthorIdd(String authorId) {
        this.authorId = authorId;
    }

    public Long getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(Long documentTypeId) {
        this.documentTypeId = documentTypeId;
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
