public class IntermediateState extends State {

    public IntermediateState(Character character) {
        super(character);
    }

    @Override
    public void action() {
        if (this.getCharacter().getExperiencePoints() < 35) {
            this.getCharacter().showCharacterStatus();

            boolean isCorrectInput = false;
            String[] options = {"Train", "Meditate"};
            while (!isCorrectInput) {
                switch (this.getCharacter().readInput(options)) {
                    case 1:
                        this.getCharacter().train();
                        isCorrectInput = true;
                        break;
                    case 2:
                        this.getCharacter().meditate();
                        isCorrectInput = true;
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
            this.getCharacter().setTurn();
        } else {
            System.out.println("\n------------------------------\nNEXT LEVEL REACHED!\n------------------------------");
            this.getCharacter().setState(new ExpertState(this.getCharacter()));
        }
    }

    @Override
    public String toString() {
        return "Intermediate";
    }
}
