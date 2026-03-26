import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        User user1 = new User("All access");
        User user2 = new User("Regular");
        User user3 = new User("Special Permission");

        library.addDocument("Everyone can access this document");
        library.addProtectedDocument("This document wad opened with an access", user1);
        library.addProtectedDocument("This is another document that requires access", user1);
        library.addDocument("This is for everyone");

        // Give access to user1 and user3 to this document:
        int docId = library.addProtectedDocument("Only the \"creator\" and people who where specially give access to this document can see this.", user1);
        library.giveAccess(docId, user3);

        HashMap<Integer, Document> allDocs = library.getAllDocuments();

        // Regular user tries to read all documents:
        System.out.println("Regular User: ");
        for (Integer key : allDocs.keySet()) {
            Document doc = allDocs.get(key);
            System.out.println("Document ID: " + doc.getId());
            System.out.println("Creation Date: " + doc.getCreationDate());
            try {
                String content = doc.getContent(user2);
                System.out.println("ACCESS GRANTED!");
                System.out.println("Content: ");
                System.out.println(content);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

        System.out.println();

        // All access user tries to read all documents:
        System.out.println("All Access User: ");
        for (Integer key : allDocs.keySet()) {
            Document doc = allDocs.get(key);
            System.out.println("Document ID: " + doc.getId());
            System.out.println("Creation Date: " + doc.getCreationDate());
            try {
                String content = doc.getContent(user1);
                System.out.println("ACCESS GRANTED!");
                System.out.println("Content: ");
                System.out.println(content);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

        System.out.println();

        // Special Permission user tries to read all documents:
        System.out.println("Special Permission User: ");
        for (Integer key : allDocs.keySet()) {
            Document doc = allDocs.get(key);
            System.out.println("Document ID: " + doc.getId());
            System.out.println("Creation Date: " + doc.getCreationDate());
            try {
                String content = doc.getContent(user3);
                System.out.println("ACCESS GRANTED!");
                System.out.println("Content: ");
                System.out.println(content);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }
}
