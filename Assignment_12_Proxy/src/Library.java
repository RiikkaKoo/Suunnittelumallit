import java.util.HashMap;

public class Library {

    private final HashMap<Integer, Document> DOCUMENTS = new HashMap<>();

    public Library() {
    }

    public int addProtectedDocument(String content, User user) {
        RealDocument realDocument = new RealDocument(content);
        Document proxyDocument = new DocumentProxy(realDocument);
        AccessControlService.getInstance().addAnAccess(user.getUsername(), proxyDocument.getId());
        DOCUMENTS.put(proxyDocument.getId(), proxyDocument);
        return proxyDocument.getId();
    }

    public void addDocument(String content) {
        Document realDocument = new RealDocument(content);
        DOCUMENTS.put(realDocument.getId(), realDocument);
    }

    public void giveAccess(int docId, User user) {
        AccessControlService.getInstance().addAnAccess(user.getUsername(), docId);
    }

    public Document getADocument(int id) {
        return DOCUMENTS.get(id);
    }

    public HashMap<Integer, Document> getAllDocuments() {
        return DOCUMENTS;
    }
}
