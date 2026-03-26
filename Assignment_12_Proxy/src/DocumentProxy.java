import java.time.LocalDate;

public class DocumentProxy implements Document {

    private int id;
    private LocalDate created;
    private RealDocument protectedDoc;

    public DocumentProxy(RealDocument realDocument) {
        this.id = realDocument.getId();
        this.created =  realDocument.getCreationDate();
        this.protectedDoc = realDocument;
    }

    @Override
    public int getId() {return this.id;}

    @Override
    public LocalDate getCreationDate() {return this.created;}

    @Override
    public String getContent(User user) {
        AccessControlService accessControl = AccessControlService.getInstance();
        if (accessControl.isAllowed(user.getUsername(), this.id)) {
            return protectedDoc.getContent(user);
        } else {
            throw new AccessDeniedException("User \"" + user.getUsername() + "\" is not allowed to access this document");
        }
    }
}
