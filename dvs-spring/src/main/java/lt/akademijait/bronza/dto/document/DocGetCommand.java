package lt.akademijait.bronza.dto.document;

import lt.akademijait.bronza.entities.Attachment;
import lt.akademijait.bronza.entities.DocType;
import lt.akademijait.bronza.entities.User;

import java.time.LocalDate;
import java.util.List;

public class DocGetCommand {

    private Long id;
    private User author;
    private DocType docType;
//    private DocState docState;
    private String title;
    private String description;
    private LocalDate creationDate;
    private LocalDate submissionDate;
    private LocalDate confirmationDate;
    private LocalDate rejectionDate;
    private User reviewer;
    private String rejectionReason;
    private List<Attachment> attachments;
//    private String path;


    public DocGetCommand(Long id) {

    }

    public DocGetCommand(Long id, User author, DocType docType, String title, String description, LocalDate creationDate, LocalDate submissionDate, LocalDate confirmationDate, LocalDate rejectionDate, User reviewer, String rejectionReason, List<Attachment> attachments) {
        this.id = id;
        this.author = author;
        this.docType = docType;
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

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
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
