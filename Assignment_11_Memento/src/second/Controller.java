package second;

// MADE WITH CHATGPT BASED ON THE CODE IN THE OFFICIAL PACKAGE! STILL DOES NOT WORK...

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Model model;
    private Gui gui;

    // Yksi historia + indeksi (Paint.NET-tyyli)
    private List<IMemento> history;
    private int currentIndex = -1;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
    }

    // =========================
    // MODEL MUUTOKSET
    // =========================

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setLastChange("ColorBox " + optionNumber + " - Choice: " + choice);
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

    // =========================
    // HISTORY LOGIC
    // =========================

    private void saveToHistory() {
        // Poista kaikki "tulevaisuus"
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }

        IMemento currentState = model.createMemento(false, null, null);
        history.add(currentState);
        currentIndex++;

        giveHistory();
    }

    public void undo() {
        if (currentIndex > 0) {
            currentIndex--;

            IMemento state = history.get(currentIndex);
            model.restoreState(state);

            gui.updateGui();
            giveHistory();
        }
    }

    public void redo() {
        if (currentIndex < history.size() - 1) {
            currentIndex++;

            IMemento state = history.get(currentIndex);
            model.restoreState(state);

            gui.updateGui();
            giveHistory();
        }
    }

    // =========================
    // HISTORIASTA VALINTA
    // =========================

    public void selectFromHistory(IMemento selected) {
        int index = history.indexOf(selected);
        if (index == -1) return;

        currentIndex = index;

        model.restoreState(selected);
        gui.updateGui();
        giveHistory();
    }

    // =========================
    // GUI:lle historia
    // =========================

    public void giveHistory() {
        for (int i = 0; i < history.size(); i++) {
            // kaikki currentIndexin jälkeen = redo-tilaa
            history.get(i).setIsRedo(i > currentIndex);
        }

        ObservableList<IMemento> items = FXCollections.observableArrayList(history);
        gui.displayHistory(items);
    }
}

