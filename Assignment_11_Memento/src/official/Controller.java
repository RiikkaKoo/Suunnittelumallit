package official;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // official.Memento history
    private List<IMemento> future; // official.Memento future

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.future = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setLastChange("official.ColorBox " + optionNumber + " - Choice: " + choice);
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setLastChange("Checkbox: " + isSelected);
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }


    public void undo() {
        System.out.println("History: " + history);
        System.out.println("Future: " + future);
        if (!history.isEmpty()) {
            System.out.println("Previous memento found in history");

            IMemento previousState = history.remove(history.size() -1);
            previousState.setIsRedo(true);
            future.addFirst(previousState);
            model.restoreState(previousState);
            gui.updateGui();
            giveHistory();
        }
    }

    public void redo() {
        System.out.println("History: " + history);
        System.out.println("Future: " + future);
        if (!future.isEmpty()) {
            System.out.println("Future memento found in history");

            IMemento futureState = future.removeFirst();
            futureState.setIsRedo(false);
            history.add(futureState);
            model.restoreState(futureState);
            gui.updateGui();
            giveHistory();
        }
    }

    private void saveToHistory() {
        if (!future.isEmpty()) {
            future.clear();
        }
        IMemento currentState = model.createMemento(false, null, null);
        history.add(currentState);
        giveHistory();
    }

    public void giveHistory() {
        ObservableList<IMemento> historyItems = FXCollections.observableArrayList(history);
        historyItems.addAll(future);
        gui.displayHistory(historyItems);
    }

    public void selectFromHistory(IMemento selected) {
        List<IMemento> allStates = new ArrayList<>(history);
        allStates.addAll(future);

        int selectedIndex = allStates.indexOf(selected);

        List<IMemento> newHistory = new ArrayList<>(allStates.subList(0, selectedIndex));

        List<IMemento> newFuture = new ArrayList<>(allStates.subList(selectedIndex, allStates.size()));

        for (IMemento m : newHistory) {
            m.setIsRedo(false);
        }
        for (IMemento m : newFuture) {
            m.setIsRedo(true);
        }

        history = newHistory;
        future = newFuture;

        System.out.println("History: " + history);
        System.out.println("Future: " + future);
        System.out.println("Current: " + selected);

        model.restoreState(selected);

        gui.updateGui();
        giveHistory();
    }

}
