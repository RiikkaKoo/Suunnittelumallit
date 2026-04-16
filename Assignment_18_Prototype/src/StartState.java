public class StartState extends State {

    public StartState(RecommendationApp recommendationApp) {
        super(recommendationApp);
    }

    @Override
    public void operate() {
        boolean isCorrectInput = false;
        String[] options = {"View Recommendations", "Clone and modify a recommendation list", "Quit"};
        while (!isCorrectInput) {
            switch (this.getApp().readInput(options)) {
                case 1:
                    this.getApp().showRecommendations();
                    isCorrectInput = true;
                    break;
                case 2:
                    this.getApp().cloneARecommendation();
                    this.getApp().setState(new ModifyState(this.getApp()));
                    isCorrectInput = true;
                    break;
                case 3:
                    this.getApp().setIsQuit(true);
                    isCorrectInput = true;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }
}
