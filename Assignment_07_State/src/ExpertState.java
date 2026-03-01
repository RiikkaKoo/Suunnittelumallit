public class ExpertState extends State {

    public ExpertState(Character character) {
        super(character);
    }

    @Override
    public void action() {
        if (this.getCharacter().getExperiencePoints() < 50) {
            this.getCharacter().showCharacterStatus();

            boolean isCorrectInput = false;
            String[] options = {"Train", "Meditate", "Fight"};
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
                    case 3:
                        this.getCharacter().fight();
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
            this.getCharacter().setState(new MasterState(this.getCharacter()));
        }
    }

    @Override
    public String toString() {
        return "Expert";
    }
}
