import java.util.List;

public class ChatWindowController implements Colleague {

    private String chatterName;
    private Mediator communicator;
    private ChatWindow chatWindow;

    public ChatWindowController(Mediator communicator, String name) {
        this.communicator = communicator;
        this.chatWindow = new ChatWindow(name,this);
        this.chatterName = name;
        chatWindow.openChatWindow();
        communicator.registerChatter(this);
        communicator.updateChatters();
    }

    @Override
    public String giveChatterName() {
        return this.chatterName;
    }

    @Override
    public void receiveChatterNames(List<String> names) {
        chatWindow.updateChatters(names);
    }

    @Override
    public void receiveMessage(String message, String sender) {
        chatWindow.displayMessage(message, sender);
    }

    @Override
    public void sendMessage(String message, String receiver) {
        communicator.relayMessage(message, chatterName, receiver);
    }
}
