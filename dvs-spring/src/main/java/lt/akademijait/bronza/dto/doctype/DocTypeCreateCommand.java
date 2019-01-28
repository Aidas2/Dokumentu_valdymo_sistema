package lt.akademijait.bronza.dto.doctype;

public class DocTypeCreateCommand {
//    private Long id;
    private String title;

    public DocTypeCreateCommand() {
    }

    public DocTypeCreateCommand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
