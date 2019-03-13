package lt.akademijait.bronza.dto.user;

import lt.akademijait.bronza.entities.Role;
import lt.akademijait.bronza.entities.UserGroup;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.Set;


public class UserCreateCommand {

    @NotNull
    @Length(min = 1, max = 50)
    private String firstName;

    @NotNull
    @Length(min = 1, max = 50)
    private String lastName;

    @Column
    @PastOrPresent
    private Date hireDate;

    @NotNull
    private boolean administrator;

    @NotNull
    @Length(min = 6, max = 20)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String emailAddress;

    @ManyToMany
    private Set<String> userGroupTitle;

//    private String roleTitle;


    public UserCreateCommand() {
    }

    public UserCreateCommand(@NotNull @Length(min = 1, max = 50) String firstName,
                             @NotNull @Length(min = 1, max = 50) String lastName, Date hireDate,
                             @NotNull boolean administrator, @NotNull @Length(min = 6, max = 20) String username,
                             @NotNull String password, @NotNull @Email String emailAddress, Set<String> userGroupTitle/*, String roleTitle*/) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.administrator = administrator;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.userGroupTitle = userGroupTitle;
//        this.roleTitle=roleTitle;
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

//    public String getRoleTitle() {
//        return roleTitle;
//    }
//
//    public void setRoleTitle(String roleTitle) {
//        this.roleTitle = roleTitle;
//    }
}
