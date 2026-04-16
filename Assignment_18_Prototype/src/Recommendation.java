import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {

    private String targetAudience;
    private List<Book> books = new ArrayList<>();

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation clone = (Recommendation) super.clone();
            clone.books = new ArrayList<>();

            for (Book b : books) {
                clone.addBook(b.clone());
            }
            return clone;
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            throw new AssertionError();
        }
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }
}
