package lt.akademijait.bronza.entities;


import lt.akademijait.bronza.enums.DocumentState;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="DOCUMENT")
//@Table(name="DOCUMENT", uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column
    //private Long documentId;

    @ManyToOne
    @JoinColumn(name="author_id")
    private User author;

    @Column
    private DocumentState documentState;

    @ManyToOne
    @JoinColumn(name="doctype_id")
    private DocumentType documentType;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private LocalDate creationDate;

    @Column
    private LocalDate submissionDate;

    @Column
    private LocalDate confirmationDate;

    @Column
    private LocalDate rejectionDate;

    @ManyToOne
    private User reviewer;

    @Column
    private String rejectionReason;

    @OneToMany
    private List<Attachment> attachments;

    //@Column
    //private String path;


    //Constructors:

    public Document() {

    }

    public Document(User author, DocumentState documentState, DocumentType documentType, String title, String description, LocalDate creationDate, LocalDate submissionDate, LocalDate confirmationDate, LocalDate rejectionDate, User reviewer, String rejectionReason, List<Attachment> attachments) {
        this.author = author;
        this.documentState = documentState;
        this.documentType = documentType;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.submissionDate = submissionDate;
        this.confirmationDate = confirmationDate;
        this.rejectionDate = rejectionDate;
        this.reviewer = reviewer;
        this.rejectionReason = rejectionReason;
        this.attachments = attachments;
    }

    //Getters and Setters:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public DocumentState getDocumentState() {
        return documentState;
    }

    public void setDocumentState(DocumentState documentState) {
        this.documentState = documentState;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public LocalDate getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(LocalDate confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public LocalDate getRejectionDate() {
        return rejectionDate;
    }

    public void setRejectionDate(LocalDate rejectionDate) {
        this.rejectionDate = rejectionDate;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

}
