package lt.akademijait.bronza.dto.document;


//this is experimental class, not necessary

import lt.akademijait.bronza.entities.DocumentType;

public class DocumentUpdateCommand {
    //private User author; // private String username;
    //private DocumentState documentState;
    private DocumentType documentType; //private String documentTypeTitle;
    private String title;
    private String description;

    public DocumentUpdateCommand() {
    }

    public DocumentUpdateCommand(DocumentType documentType, String title, String description) {
        this.documentType = documentType;
        this.title = title;
        this.description = description;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
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


