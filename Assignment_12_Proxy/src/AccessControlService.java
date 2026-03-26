import java.util.ArrayList;
import java.util.HashMap;

public class AccessControlService {

    private static AccessControlService instance;
    private final HashMap<String, ArrayList<Integer>> ACCESS = new HashMap<>();

    private AccessControlService() {}

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void addAnAccess(String username, int docId) {
        if (ACCESS.containsKey(username)) {
            ArrayList<Integer> docs = ACCESS.get(username);
            docs.add(docId);
        } else {
            ArrayList<Integer> docsList = new ArrayList<>();
            docsList.add(docId);
            ACCESS.put(username, docsList);
        }
    }

    public boolean isAllowed(String username, int docId) {
        try {
            ArrayList<Integer> docsList = ACCESS.get(username);
            return docsList.contains(docId);
        } catch (Exception e) {
            return false;
        }
    }
}
