package lt.akademijait.bronza.dto.user;

import javax.persistence.ManyToMany;
import java.util.Set;

public class UserAddToGroupCommand {

    @ManyToMany
    private Set<String> userGroupTitle;

    public UserAddToGroupCommand(){

    }

    public UserAddToGroupCommand(Set<String> userGroupTitle) {
        this.userGroupTitle = userGroupTitle;
    }

    public Set<String> getUserGroupTitle() {
        return userGroupTitle;
    }

    public void setUserGroupTitle(Set<String> userGroupTitle) {
        this.userGroupTitle = userGroupTitle;
    }
}
