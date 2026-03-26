import java.time.LocalDate;

public interface Document {

    public LocalDate getCreationDate();
    public int getId();
    public String getContent(User user);

}
