// The Receiver
public class ControlSystem {

    private GUI gui;
    private int[][] pixels;
    private int currentRow;
    private int currentColumn;

    public ControlSystem(GUI gui) {
        this.gui = gui;
        this.currentRow = 0;
        this.currentColumn = 0;
        this.pixels = new int[8][8];
        gui.displayCursor(currentRow, currentColumn);
    }

    public void moveCursorUp() {
        if (currentRow > 0) {
            currentRow--;
        } else {
            currentRow = 7;
        }
        System.out.println("ControlSystem: UP");
        gui.displayCursor(currentRow, currentColumn);
    }

    public void moveCursorDown() {
        if (currentRow < 7) {
            currentRow++;
        } else {
            currentRow = 0;
        }
        System.out.println("ControlSystem: DOWN");
        gui.displayCursor(currentRow, currentColumn);
    }

    public void moveCursorLeft() {
        if (currentColumn > 0) {
            currentColumn--;
        } else {
            currentColumn = 7;
        }
        System.out.println("ControlSystem: LEFT");
        gui.displayCursor(currentRow, currentColumn);
    }

    public void moveCursorRight() {
        if (currentColumn < 7) {
            currentColumn++;
        } else {
            currentColumn = 0;
        }
        System.out.println("ControlSystem: RIGHT");
        gui.displayCursor(currentRow, currentColumn);
    }

    public void togglePixel() {
        //Change selected from 0 to 1 or from 1 to 0
        pixels[currentRow][currentColumn] = pixels[currentRow][currentColumn] == 1 ? 0 : 1;

        // Check if it was selected
        boolean isSelected = pixels[currentRow][currentColumn] == 1;
        System.out.println("ControlSystem: TOGGLE, [" + currentRow + "][" + currentColumn + "], Value: " + isSelected);

        gui.togglePixel(isSelected, currentRow, currentColumn);
    }

    public void generateCode() {
        System.out.println("ControlSystem: GENERATE CODE\n");
        System.out.println("int[][] pixelArt = {");
        int rowCount = 0;
        for (int[] row : pixels) {
            if (rowCount == 0) {
                System.out.print("    {");
            } else {
                System.out.print("\n    {");
            }

            int columnCount = 0;
            for (int column : row) {
                if (columnCount == 7) {
                    System.out.print(column);
                } else {
                    System.out.print(column + ", ");
                }
                columnCount++;
            }
            if (rowCount == 7) {
                System.out.print("}");
            } else {
                System.out.print("},");
            }
            rowCount++;
        }
        System.out.print("\n};");
    }
}
