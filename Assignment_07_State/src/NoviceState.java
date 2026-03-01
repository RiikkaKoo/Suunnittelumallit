public class NoviceState extends State {

    public NoviceState(Character character) {
        super(character);
    }

    @Override
    public void action() {
        if (this.getCharacter().getExperiencePoints() < 20) {
            this.getCharacter().showCharacterStatus();

            boolean isCorrectInput = false;
            String[] options = {"Train"};
            while (!isCorrectInput) {
                switch (this.getCharacter().readInput(options)) {
                    case 1:
                        this.getCharacter().train();
                        isCorrectInput = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            this.getCharacter().setTurn();
        } else {
            System.out.println("\n------------------------------\nNEXT LEVEL REACHED!\n------------------------------");
            this.getCharacter().setState(new IntermediateState(this.getCharacter()));
        }
    }

    @Override
    public String toString() {
        return "Novice";
    }
}
