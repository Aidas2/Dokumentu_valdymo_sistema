package lt.akademijait.bronza.dto.documenttype;

import java.util.Objects;

public class DocumentTypeGetCommand {

    private Long id;
    private String title;

    public DocumentTypeGetCommand() {
    }

    public DocumentTypeGetCommand(Long id, String title) {
        this.id = id;
        this.title = title;
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

    // Generate... --> equals() and hashCode() --> next next next
    // this is for not repeating of dto (see method getDocumentTypeTitlesOfSubmittingUser2)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTypeGetCommand that = (DocumentTypeGetCommand) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }
}
