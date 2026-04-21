import java.util.ArrayList;
import java.util.List;

public class Communicator implements Mediator {

    private List<Colleague> chatControllers;

    public Communicator() {
        this.chatControllers = new ArrayList<>();
    }

    @Override
    public void registerChatter(Colleague chatter) {
        this.chatControllers.add(chatter);
    }

    @Override
    public void updateChatters() {
        System.out.println("Communicator: ");
        List<String> names = new ArrayList<>();
        for (Colleague c : chatControllers) {
            names.add(c.giveChatterName());
        }
        for (Colleague c : chatControllers) {
            c.receiveChatterNames(names);
        }
    }

    @Override
    public void relayMessage(String message, String sender, String receiver) {
        for (Colleague c : chatControllers) {
            if (c.giveChatterName().equals(receiver)) {
                c.receiveMessage(message, sender);
            }
        }

    }
}
