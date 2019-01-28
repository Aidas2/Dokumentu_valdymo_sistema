package lt.akademijait.bronza.dto.doctype;

public class DocTypeGetCommand {
    private String id;
    private String title;

    public DocTypeGetCommand() {
    }

    public DocTypeGetCommand(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
