package lt.akademijait.bronza.dto.documenttype;

public class DocumentTypeCreateCommand {

    //private Long id;
    private String title;

    public DocumentTypeCreateCommand() {
    }

    public DocumentTypeCreateCommand(String title) {
        this.title = title;
    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
