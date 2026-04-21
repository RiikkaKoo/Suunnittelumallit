import java.util.List;

public interface Colleague {
    void receiveChatterNames(List<String> names);
    String giveChatterName();
    void receiveMessage(String message, String sender);
    void sendMessage(String message, String receiver);
}
