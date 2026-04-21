import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ChatWindow {

    private String chatterName;
    private TextArea chatBox = new TextArea();
    private TextField messageField = new TextField();
    private ChoiceBox<String> chatterSelection = new ChoiceBox<>();

    private ChatWindowController controller;

    public ChatWindow(String name, ChatWindowController controller) {
        this.chatterName = name;
        this.controller = controller;
    }

    public void updateChatters(List<String> names) {
        List<String> chatters = new ArrayList<>();
        for (String name : names) {
            if (!name.equals(chatterName)) {
                System.out.println(name);
                chatters.add(name);
            }
        }
        chatterSelection.setItems(FXCollections.observableArrayList(chatters));
    }

    public void displayMessage(String message, String sender) {
        chatBox.setText(chatBox.getText() + "\n" + sender + ": " + message);
    }

    public void openChatWindow() {
        VBox mainLayout = new VBox();

        Label name = new Label(chatterName.toUpperCase() + "'S CHAT");

        VBox sendMessageBar = new VBox();
        HBox typeAndSendBar = new HBox();

        Button sendButton = new Button("SEND");
        sendButton.setOnAction(event ->
                {
                    controller.sendMessage(messageField.getText(), chatterSelection.getValue());
                    chatBox.setText(chatBox.getText() + "\nMe to " + chatterSelection.getValue() + ": " + messageField.getText());
                }
        );

        typeAndSendBar.getChildren().addAll(messageField, sendButton);
        sendMessageBar.getChildren().addAll(chatterSelection, typeAndSendBar);

        chatBox.setDisable(true);
        chatBox.setStyle("-fx-opacity: 1;" +
                "-fx-background-color: white;" +
                "-fx-text-fill: #00587c;");
        mainLayout.getChildren().addAll(name,chatBox, sendMessageBar);

        Stage stage = new Stage();
        Scene scene = new Scene(mainLayout);
        stage.setScene(scene);
        stage.setTitle("ChatWindow - " + chatterName);
        stage.show();
    }
}
