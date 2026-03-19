import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private static int count = 0;
    private int[] options;
    private boolean isSelected;
    private boolean isRedo;

    private int id;
    private String timestamp;
    private String change;

    public Memento(int[] options, boolean isSelected, boolean isRedo, String change, String timestamp) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = timestamp;
        this.isRedo = isRedo;
        this.change = change;

        count++;
        this.id = count;
        System.out.println("Memento created");
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public String getTimestamp() {return this.timestamp;}

    @Override
    public boolean getIsRedo() {return this.isRedo;}

    @Override
    public void setIsRedo(boolean isRedo) {this.isRedo = isRedo;}

    @Override
    public String getChange() {return this.change;}

    @Override
    public String toString() {
        return "" + this.id;
    }
}
