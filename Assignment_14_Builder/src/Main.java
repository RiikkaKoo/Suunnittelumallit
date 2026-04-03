public class Main {

    public static void main(String[] args) {
        ComputerBuilder builder1 = new OfficeComputerBuilder();
        ComputerBuilder builder2 = new GamingComputerBuilder();

        ComputerDirector director1 = new ComputerDirector(builder1);
        ComputerDirector director2 = new ComputerDirector(builder2);

        // Build an office computer:
        director1.constructComputer();
        Computer officeComputer = builder1.getComputer();
        System.out.println(officeComputer);

        System.out.println();

        // Build a gaming computer:
        director2.constructComputer();
        Computer gaimingComputer = builder2.getComputer();
        System.out.println(gaimingComputer);
    }
}
