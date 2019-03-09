package lt.akademijait.bronza.dto.document;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class DocumentUpdateCommand {
    //private User author; // private String username;
    //private DocumentState documentState;
    //private DocumentType documentType;  // do not use object, because object sends to swagger all his fields

    @NotNull
    @Length(min = 1, max = 30)
    private String documentTypeTitle;

    @NotNull
    @Length(min = 1, max = 50)
    private String title;

    @NotNull
    @Length(min = 1, max = 500)
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

    @Override   // this is for formatting output of logger
    public String toString() {
        return "DocumentUpdateCommand{" +
                "documentTypeTitle='" + documentTypeTitle + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


