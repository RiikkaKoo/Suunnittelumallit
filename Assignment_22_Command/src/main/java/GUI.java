import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GUI extends Application {
    private Rectangle[][] pixels = new Rectangle[8][8];

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(10);
        Group grid = drawGrid(stage);

        ControlSystem controlSystem = new ControlSystem(this);
        Command up = new MoveCursorUpCommand(controlSystem);
        Command down = new MoveCursorDownCommand(controlSystem);
        Command left = new MoveCursorLeftCommand(controlSystem);
        Command right = new MoveCursorRightCommand(controlSystem);
        Command toggle = new TogglePixelCommand(controlSystem);
        Command generate = new GenerateCodeCommand(controlSystem);

        Button button = new Button("Generate");
        button.setOnAction((event) -> {
            generate.execute();
        });
        button.setStyle("-fx-background-color: #efc164; -fx-font-size: 20; -fx-padding: 5");

        root.getChildren().addAll(grid, button);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            switch (keyEvent.getCode()) {
                case KeyCode.UP -> up.execute();
                case KeyCode.DOWN -> down.execute();
                case KeyCode.LEFT -> left.execute();
                case KeyCode.RIGHT -> right.execute();
                case KeyCode.SPACE -> toggle.execute();
            }
        });

        stage.setScene(scene);
        stage.show();
    }

    public Group drawGrid(Stage stage) {

        Group group = new Group();

        double yCoord = 0;
        int row = 0;
        for (int y = 0; y < 8; y++) {
            double xCoord = 0;
            int column = 0;
            for (int x = 0; x < 8; x++) {
                Rectangle rectangle = new Rectangle();
                rectangle.setX(xCoord);
                rectangle.setY(yCoord);
                rectangle.setWidth(80);
                rectangle.setHeight(80);
                rectangle.setFill(Color.WHITE);
                rectangle.setStroke(Color.DARKGRAY);
                group.getChildren().add(rectangle);
                pixels[row][column] = rectangle;
                xCoord += 81;
                column++;
            }
            yCoord += 81;
            row++;
        }

        return group;
    }

    public void displayCursor(int row, int column) {
        // Clear the previous selection
        for (Rectangle[] rectRow : pixels) {
            for (Rectangle rectangle : rectRow) {
                rectangle.setStroke(Color.DARKGRAY);
            }
        }

        Rectangle currentRect = pixels[row][column];
        currentRect.setStroke(Color.RED);
    }

    public void togglePixel(boolean isSelected, int row, int column) {
        Rectangle currentRect = pixels[row][column];
        if (isSelected) {
            currentRect.setFill(Color.BLACK);
        } else {
            currentRect.setFill(Color.WHITE);
        }
    }
}
