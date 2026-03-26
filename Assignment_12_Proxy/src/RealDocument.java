import java.time.LocalDate;

public class RealDocument implements Document {

    private static int idCount = 1;
    private int id;
    private LocalDate created;
    private String content;

    public RealDocument(String content) {
        this.id = idCount;
        idCount++;
        this.created = LocalDate.now();
        this.content = content;
    }

    @Override
    public int getId() {return this.id;}

    @Override
    public LocalDate getCreationDate() {return this.created;}

    @Override
    public String getContent(User user) {return this.content;}

}
