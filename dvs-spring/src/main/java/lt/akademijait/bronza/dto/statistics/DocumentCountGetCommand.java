package lt.akademijait.bronza.dto.statistics;

public class DocumentCountGetCommand {

    private int createdDocumentsCount;
    private int submittedDocumentsCount;
    private int acceptedDocumentsCount;
    private int rejectedDocumentsCount;

    public DocumentCountGetCommand() {
    }

    public DocumentCountGetCommand(int createdDocumentsCount, int submittedDocumentsCount,
                                   int acceptedDocumentsCount, int rejectedDocumentsCount) {
        this.createdDocumentsCount = createdDocumentsCount;
        this.submittedDocumentsCount = submittedDocumentsCount;
        this.acceptedDocumentsCount = acceptedDocumentsCount;
        this.rejectedDocumentsCount = rejectedDocumentsCount;
    }

    public int getCreatedDocumentsCount() {
        return createdDocumentsCount;
    }

    public void setCreatedDocumentsCount(int createdDocumentsCount) {
        this.createdDocumentsCount = createdDocumentsCount;
    }

    public int getSubmittedDocumentsCount() {
        return submittedDocumentsCount;
    }

    public void setSubmittedDocumentsCount(int submittedDocumentsCount) {
        this.submittedDocumentsCount = submittedDocumentsCount;
    }

    public int getAcceptedDocumentsCount() {
        return acceptedDocumentsCount;
    }

    public void setAcceptedDocumentsCount(int acceptedDocumentsCount) {
        this.acceptedDocumentsCount = acceptedDocumentsCount;
    }

    public int getRejectedDocumentsCount() {
        return rejectedDocumentsCount;
    }

    public void setRejectedDocumentsCount(int rejectedDocumentsCount) {
        this.rejectedDocumentsCount = rejectedDocumentsCount;
    }
}
