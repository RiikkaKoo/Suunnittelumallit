public class ComputerDirector {

    private ComputerBuilder compBuilder;

    public ComputerDirector(ComputerBuilder builder) {
        this.compBuilder = builder;
    }

    public void construct() {
        compBuilder.buildProcessor();
        compBuilder.buildRAM();
        compBuilder.buildHardDrive();
        compBuilder.buildGraphicsCard();
        compBuilder.buildOperatingSystem();
    }

}
