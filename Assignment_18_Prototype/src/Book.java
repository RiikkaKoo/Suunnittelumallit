public class Book implements Cloneable {

    private String title;
    private String author;
    private String genre;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
            throw new AssertionError();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre;
    }
}
