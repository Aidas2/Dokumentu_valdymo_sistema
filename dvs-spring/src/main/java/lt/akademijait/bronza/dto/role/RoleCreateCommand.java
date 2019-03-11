package lt.akademijait.bronza.dto.role;

public class RoleCreateCommand {


    private String title;

    public RoleCreateCommand() {
    }

    public RoleCreateCommand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
