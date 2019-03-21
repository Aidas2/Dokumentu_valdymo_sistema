package lt.akademijait.bronza.dto.user;

import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.UserGroup;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class UserUpdateCommand {

//    private Long id;

    @NotNull
    @Length(min = 1, max = 30)
    private String firstName;

    @NotNull
    @Length(min = 1, max = 30)
    private String lastName;

    @PastOrPresent
    private Date hireDate;

    @NotNull
    private boolean administrator;

//    @NotNull
//    @Length(min = 6, max = 20)
//    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String emailAddress;

    @ManyToMany
    private Set<String> userGroupTitle;


    public UserUpdateCommand() {
    }

    public UserUpdateCommand(@NotNull @Length(min = 1, max = 30) String firstName, @NotNull @Length(min = 1, max = 30) String lastName,
                             @PastOrPresent Date hireDate, @NotNull boolean administrator, @NotNull String password,
                             @NotNull @Email String emailAddress, Set<String> userGroupTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.administrator = administrator;
        this.password = password;
        this.emailAddress = emailAddress;
        this.userGroupTitle = userGroupTitle;
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
