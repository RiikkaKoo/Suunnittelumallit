public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void chooseType() {
        computer.setType("Gaming");
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i7-14700K");
    }

    @Override
    public void buildRAM() {
        computer.setRamSize(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB SSD (NVMe)");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA GeForce RTX 4070");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11");
    }

    @Override
    public Computer getComputer() {
        return this.computer;
    }

}
