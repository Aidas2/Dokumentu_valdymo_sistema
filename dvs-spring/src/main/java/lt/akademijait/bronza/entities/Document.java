package lt.akademijait.bronza.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="documents", uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;
    @Column(unique = true, nullable = false)
    private String author;
    @Column
    private String type;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private Date uploadDate;
    @Column
    private Date submitDate;
    @Column
    private Date confirmationDate;
    @Column
    private Date rejectionDate;
    @Column
    private String managedBy;
    @Column
    private String rejectionReason;

    public Document(Long docId) {

    }

    public Document(Long docId, String author, String type, String title, String description, Date uploadDate, Date submitDate, Date confirmationDate, Date rejectionDate, String managedBy, String rejectionReason) {
        this.docId = docId;
        this.author = author;
        this.type = type;
        this.title = title;
        this.description = description;
        this.uploadDate = uploadDate;
        this.submitDate = submitDate;
        this.confirmationDate = confirmationDate;
        this.rejectionDate = rejectionDate;
        this.managedBy = managedBy;
        this.rejectionReason = rejectionReason;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Date getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(Date rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    public String getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(String managedBy) {
        this.managedBy = managedBy;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }
}
