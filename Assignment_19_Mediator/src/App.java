import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    private Mediator communicator;

    @Override
    public void start(Stage stage) throws Exception {
        this.communicator = new Communicator();
        createChatWindow("Tukaani");
        createChatWindow("Kultakala");
        createChatWindow("Rusakko");
    }

    private void createChatWindow(String chatterName) {
        ChatWindowController controller = new ChatWindowController(this.communicator, chatterName);
    }
}
