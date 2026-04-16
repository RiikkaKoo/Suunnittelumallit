public class ModifyState extends State {

    public ModifyState(RecommendationApp recommendationApp) {
        super(recommendationApp);
    }

    @Override
    public void operate() {
        boolean isCorrectInput = false;
        String[] options = {"Add a book", "Remove a book", "Save", "Exit"};
        while (!isCorrectInput) {
            switch (this.getApp().readInput(options)) {
                case 1:
                    this.getApp().addABookToRecommendation();
                    isCorrectInput = true;
                    break;
                case 2:
                    this.getApp().removeABookFromRecommendation();
                    isCorrectInput = true;
                    break;
                case 3:
                    this.getApp().saveRecommendation();
                    isCorrectInput = true;
                    this.getApp().setState(new StartState(this.getApp()));
                    break;
                case 4:
                    this.getApp().clearRecommendation();
                    isCorrectInput = true;
                    this.getApp().setState(new StartState(this.getApp()));
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }
}
