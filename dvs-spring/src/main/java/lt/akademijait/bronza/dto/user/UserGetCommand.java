package lt.akademijait.bronza.dto.user;

import lt.akademijait.bronza.entities.UserGroup;

import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

public class UserGetCommand {

    private Long userId;
    private String firstName;
    private String lastName;
    private Date hireDate;
    private boolean administrator;
    private String username;
    private String password;
    //private byte[] passwordSalt;
    private String emailAddress;

    @ManyToMany
    private Set<UserGroup> userGroups;

//    @OneToMany
//    private List<Document> documents;




    public UserGetCommand() {
    }

    public UserGetCommand(Long userId, String firstName, String lastName, boolean administrator, String password, String username,
                          String emailAddress, Date hireDate, Set<UserGroup> userGroups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.administrator = administrator;
        this.password = password;
        this.username = username;
        this.emailAddress = emailAddress;
        this.userId = userId;
        this.hireDate = hireDate;
        this.userGroups = userGroups;
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }
}
