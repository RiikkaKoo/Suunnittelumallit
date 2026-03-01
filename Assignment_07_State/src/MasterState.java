public class MasterState extends State {

    public MasterState(Character character) {
        super(character);
    }

    @Override
    public void action() {
        this.getCharacter().showCharacterStatus();
        System.out.println("CONGRATULATIONS! YOU HAVE REACHED THE HIGHEST LEVEL.");

        boolean isCorrectInput = false;
        String[] options = {"Quit", "New Character"};
        while (!isCorrectInput) {
            switch (this.getCharacter().readInput(options)) {
                case 1:
                    this.getCharacter().setIsActive(false);
                    System.out.println("Goodbye!");
                    isCorrectInput = true;
                    break;
                case 2:
                    isCorrectInput = true;
                    this.getCharacter().setIsActive(false);
                    Character newCharacter = new Character();
                    newCharacter.play();
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        return "Master";
    }
}
