package lt.akademijait.bronza.dto.usergroup;

import javax.validation.constraints.NotNull;

public class UserGroupCreateCommand {

//    private Long id;
//    private Long userGroupId;

    @NotNull
    private String title;

//    private List<DocType> submissionDocType;
//    private List<DocType> reviewDocType;


    public UserGroupCreateCommand() {
    }

    public UserGroupCreateCommand(@NotNull String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
