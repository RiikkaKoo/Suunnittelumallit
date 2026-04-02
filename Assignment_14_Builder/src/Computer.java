public class Computer {

    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SPECS:\n")
                .append("  - Processor: ").append(processor)
                .append("\n  - RAM: ").append(ramSize)
                .append(" GB\n  - Hard Drive: ").append(hardDrive)
                .append("\n  - Graphics Card: ").append(graphicsCard)
                .append("\n  - OS: ").append(operatingSystem);
        return stringBuilder.toString();
    }
}
