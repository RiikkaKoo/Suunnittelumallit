import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Model {
    private int[] options = new int[3];
    private boolean isSelected;
    private String lastChange;

    public void setOption(int optionNumber, int choice) {
        System.out.println("optionNumber: " + optionNumber + " choice: " + choice);
        if (optionNumber >= 1 && optionNumber <= 3) {
            options[optionNumber - 1] = choice;
        }
    }

    public int getOption(int optionNumber) {
        if (optionNumber >= 1 && optionNumber <= 3) {
            return options[optionNumber - 1];
        }
        return -1;
    }

    public void setIsSelected(boolean isSelected) {
        System.out.println("isSelected: " + isSelected);
        this.isSelected = isSelected;
    }

    public boolean getIsSelected() {
        return isSelected;
    }

    public void setLastChange(String change) {
        this.lastChange = change;
    }

    public String getLastChange() {
        return this.lastChange;
    }

    // method to save the state of the model
    public IMemento createMemento(boolean isRedo, String timestamp, String lastChange) {
        String correctTimestamp;
        if (timestamp == null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            LocalDateTime time = LocalDateTime.now();
            correctTimestamp = formatter.format(time);
        } else {
            correctTimestamp = timestamp;
        }
        String change = lastChange == null ? this.lastChange : lastChange;
        return new Memento(options, isSelected, isRedo, change, correctTimestamp);
    }


    // method to restore the state of the model
    public void restoreState(IMemento memento) {
        Memento selectionMemento = (Memento) memento;
        options = selectionMemento.getOptions();
        System.out.println("options: " + options[0] + " " + options[1] + " " + options[2]);
        isSelected = selectionMemento.isSelected();
        System.out.println("isSelected: " + isSelected);
        System.out.println("State restored");
    }
}