public class ComputerDirector {

    private ComputerBuilder compBuilder;

    public ComputerDirector(ComputerBuilder builder) {
        this.compBuilder = builder;
    }

    public void constructComputer() {
        compBuilder.chooseType();
        compBuilder.buildProcessor();
        compBuilder.buildRAM();
        compBuilder.buildHardDrive();
        compBuilder.buildGraphicsCard();
        compBuilder.buildOperatingSystem();
    }

}
