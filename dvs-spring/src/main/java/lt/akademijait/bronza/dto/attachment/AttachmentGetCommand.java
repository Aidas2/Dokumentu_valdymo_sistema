package lt.akademijait.bronza.dto.attachment;

public class AttachmentGetCommand {

    private Long id;
    private String title;
    private String path;

    public AttachmentGetCommand(Long id, String title, String path) {
        this.id = id;
        this.title = title;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
