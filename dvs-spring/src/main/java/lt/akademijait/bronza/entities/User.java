package lt.akademijait.bronza.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private Date hireDate;
    @Column
    boolean isAdministrator;
    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String emailAddress;

    public User() {

    }

    public User(Long userID, String firstName, String lastName, Date hireDate, Boolean isAdministrator, String username, String password, String emailAddress) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.isAdministrator = isAdministrator;
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public Boolean getAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(Boolean administrator) {
        isAdministrator = administrator;
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
