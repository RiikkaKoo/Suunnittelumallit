public class Computer {

    private String type;
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    public void setType(String type) {
        this.type = type;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        String stringBuilder = "SPECS:\n" +
                "  - Recommended for: " + type +
                "\n  - Processor: " + processor +
                "\n  - RAM: " + ramSize +
                " GB\n  - Hard Drive: " + hardDrive +
                "\n  - Graphics Card: " + graphicsCard +
                "\n  - OS: " + operatingSystem;
        return stringBuilder;
    }
}
