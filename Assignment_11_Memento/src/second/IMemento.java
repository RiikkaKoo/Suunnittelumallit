package second;

public interface IMemento {
    // memento metadata methods
    String getTimestamp();
    boolean getIsRedo();
    void setIsRedo(boolean isRedo);
    String getChange();


}
