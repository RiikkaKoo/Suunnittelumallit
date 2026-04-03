public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void chooseType() {
        computer.setType("Office");
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i5-13400");
    }

    @Override
    public void buildRAM() {
        computer.setRamSize(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Integrated Graphics");
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
