package lt.akademijait.bronza.dto.user;

import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.UserGroup;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class UserUpdateCommand {

//    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column
    private Date hireDate;

    @NotNull
    private boolean administrator;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String emailAddress;

    @ManyToMany
    private Set<String> userGroupTitle;


    public UserUpdateCommand() {
    }


    public UserUpdateCommand(@NotNull String firstName, @NotNull String lastName,
                             Date hireDate, @NotNull boolean administrator,
                             @NotNull String username, @NotNull String password,
                             @NotNull String emailAddress, Set<String> userGroupTitle) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.administrator = administrator;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.userGroupTitle = userGroupTitle;
//        this.documents = documents;
    }


    public String getFirstName() {
        return firstName;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
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

    public Set<String> getUserGroupTitle() {
        return userGroupTitle;
    }

    public void setUserGroupTitle(Set<String> userGroupTitle) {
        this.userGroupTitle = userGroupTitle;
    }

}
