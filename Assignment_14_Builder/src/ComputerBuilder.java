public interface ComputerBuilder {

    void chooseType();
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    Computer getComputer();

}
