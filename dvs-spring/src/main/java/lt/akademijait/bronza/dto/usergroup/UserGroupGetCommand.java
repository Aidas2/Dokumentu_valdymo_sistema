package lt.akademijait.bronza.dto.usergroup;

public class UserGroupGetCommand {

//    private Long id;
//    private Long userGroupId;

    private String title;

//    private List<DocType> submissionDocType;
//    private List<DocType> reviewDocType;


    public UserGroupGetCommand() {
    }

    public UserGroupGetCommand(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
