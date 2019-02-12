package lt.akademijait.bronza.dto.user;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserCreateCommand {

    private Long id;

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

    //@Column
    //private byte[] passwordSalt;

    @NotNull
    private String emailAddress;

    //@ManyToMany
    //private List<UserGroup> userGroups;

    //@OneToMany
    //private List<Document> documents;


    public UserCreateCommand() {
    }

    public UserCreateCommand(Long id, @NotNull String firstName, @NotNull String lastName, Date hireDate, @NotNull boolean administrator, @NotNull String username, @NotNull String password, @NotNull String emailAddress) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.administrator = administrator;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        //this.userGroups = userGroups;
        //this.documents = documents;
    }

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
/*
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
    }*/
}
