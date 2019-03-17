package lt.akademijait.bronza.dto.statistics;

public class DocumentCountGetCommand {

    private int allDocumentsCount;
    private int submittedDocumentsCount;
    private int acceptedDocumentsCount;
    private int rejectedDocumentsCount;

    public DocumentCountGetCommand() {
    }

    public DocumentCountGetCommand(int allDocumentsCount, int submittedDocumentsCount,
                                   int acceptedDocumentsCount, int rejectedDocumentsCount) {
        this.allDocumentsCount = allDocumentsCount;
        this.submittedDocumentsCount = submittedDocumentsCount;
        this.acceptedDocumentsCount = acceptedDocumentsCount;
        this.rejectedDocumentsCount = rejectedDocumentsCount;
    }

    public int getAllDocumentsCount() {
        return allDocumentsCount;
    }

    public void setAllDocumentsCount(int allDocumentsCount) {
        this.allDocumentsCount = allDocumentsCount;
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
