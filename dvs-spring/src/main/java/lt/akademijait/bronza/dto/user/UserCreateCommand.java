package lt.akademijait.bronza.dto.user;

import javax.validation.constraints.NotNull;

public class UserCreateCommand {

//    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

//    @Column
//    private LocalDate hireDate;

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

//    @ManyToMany
//    private List<UserGroup> userGroups;

//    @OneToMany
//    private List<Document> documents;


    public UserCreateCommand() {
    }

    public UserCreateCommand(@NotNull String firstName, @NotNull String lastName, @NotNull boolean administrator, @NotNull String username, @NotNull String password, @NotNull String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.administrator = administrator;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
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
}
