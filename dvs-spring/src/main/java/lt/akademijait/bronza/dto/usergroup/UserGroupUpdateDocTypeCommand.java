package lt.akademijait.bronza.dto.usergroup;

import java.util.Set;

public class UserGroupUpdateDocTypeCommand {

    private Set<String> DocumentType;

    public UserGroupUpdateDocTypeCommand() {
    }

    public UserGroupUpdateDocTypeCommand(Set<String> DocumentType) {
        this.DocumentType = DocumentType;
    }

    public Set<String> getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(Set<String> DocumentType) {
        this.DocumentType = DocumentType;
    }
}
