package lt.akademijait.bronza.dto.role;

public class RoleGetCommand {

    private String title;

    public RoleGetCommand() {
    }

    public RoleGetCommand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
