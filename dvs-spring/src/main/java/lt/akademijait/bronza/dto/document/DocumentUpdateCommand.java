package lt.akademijait.bronza.dto.document;


public class DocumentUpdateCommand {
    //private User author; // private String username;
    //private DocumentState documentState;
    //private DocumentType documentType;  // do not use object, because object sends to swagger all his fields
    private String documentTypeTitle;

    private String title;
    private String description;

    public DocumentUpdateCommand() {
    }

    public DocumentUpdateCommand(String documentTypeTitle, String title, String description) {
        this.documentTypeTitle = documentTypeTitle;
        this.title = title;
        this.description = description;
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

    @Override
    public String toString() {
        return "DocumentUpdateCommand{" +
                "documentTypeTitle='" + documentTypeTitle + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


