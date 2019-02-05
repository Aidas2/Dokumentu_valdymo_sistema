package lt.akademijait.bronza.dto.user;

import lt.akademijait.bronza.entities.Document;
import lt.akademijait.bronza.entities.UserGroup;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class UserUpdateCommand {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Column
    private LocalDate hireDate;

    @NotNull
    private boolean administrator;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String emailAddress;

    @ManyToMany
    private List<UserGroup> userGroups;

    @OneToMany
    private List<Document> documents;

    public UserUpdateCommand() {
    }

//    public UserUpdateCommand(Long id, @NotNull String firstName, @NotNull String lastName, LocalDate hireDate, @NotNull boolean administrator, @NotNull String username, @NotNull String password, @NotNull String emailAddress, List<UserGroup> userGroups, List<Document> documents) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.hireDate = hireDate;
//        this.administrator = administrator;
//        this.username = username;
//        this.password = password;
//        this.emailAddress = emailAddress;
//        this.userGroups = userGroups;
//        this.documents = documents;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
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

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
