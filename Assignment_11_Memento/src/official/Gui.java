package official;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    // create a GUI with three adjacent ColorBoxes and one CheckBox below them
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;
    private ListView<IMemento> historyList = new ListView<IMemento>();
    private boolean ignoreSelection = false;

    public void start(Stage stage) {

        controller = new Controller(this);

        // Insets for margin and padding
        Insets insets = new Insets(10, 10, 10, 10);

        // Create three ColorBoxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create a CheckBox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Add the ColorBoxes and CheckBox to a HBox
        HBox hBox = new HBox(colorBox1.getRectangle(), colorBox2.getRectangle(), colorBox3.getRectangle());
        hBox.setSpacing(10);

        hBox.setMargin(colorBox1.getRectangle(), insets);
        hBox.setMargin(colorBox2.getRectangle(), insets);
        hBox.setMargin(colorBox3.getRectangle(), insets);


        Label label = new Label("Press Ctrl-Z to undo the last change.");
        label.setPadding(insets);
        Label label2 = new Label("Press Ctrl-Y to redo the last change.");
        label.setPadding(insets);

        Button openHistoryBtn = new Button("Open history");
        openHistoryBtn.setOnAction(event -> openHistory());

        // create a VBox that contains the HBox and the CheckBox
        VBox vBox = new VBox(hBox, checkBox, label, label2, openHistoryBtn);
        // call controller when the CheckBox is clicked
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Set the HBox to be the root of the Scene
        Scene scene = new Scene(vBox);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                // Ctrl-Z: undo
                System.out.println("Undo key combination pressed");
                controller.undo();
            } else if (event.isControlDown() && event.getCode() == KeyCode.Y) {
                // Ctrl-Y: redo
                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });


        stage.setScene(scene);
        stage.setTitle("official.Memento Pattern Example");
        stage.show();
    }

    public void updateGui() {
        // called after restoring state from a official.Memento
        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));
        checkBox.setSelected(controller.getIsSelected());
    }

    public void openHistory() {
        VBox historyBox = new VBox();
        controller.giveHistory();

        historyBox.getChildren().addAll(historyList);
        historyList.setStyle("-fx-control-inner-background: #f0fffa;");

        historyList.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            if (ignoreSelection) return;
            controller.selectFromHistory(selected);
        });

        Stage stage = new Stage();
        Scene scene = new Scene(historyBox);
        stage.setScene(scene);
        stage.setTitle("official.Memento Pattern Example");
        stage.show();
    }

    public void displayHistory(ObservableList<IMemento> history) {
        ignoreSelection = true;
        historyList.setItems(history);
        historyList.setCellFactory(lv -> new ListCell<IMemento>() {
            @Override
            protected void updateItem(IMemento item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item.getTimestamp() + " " + item.getChange());

                    if (isSelected()) {
                        setStyle("");
                    } else {
                        boolean isRedo = item.getIsRedo();

                        if (isRedo) {
                            setStyle("-fx-background-color: #b0fffe; -fx-text-fill: #575757;");
                        } else {
                            setStyle("-fx-background-color: white; -fx-text-fill: black;");
                        }
                    }
                }
            }
        });
        ignoreSelection = false;
    }
}
