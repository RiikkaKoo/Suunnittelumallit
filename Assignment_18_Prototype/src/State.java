public abstract class State {

    private RecommendationApp recommendationApp;

    public State(RecommendationApp recommendationApp) {
        this.recommendationApp = recommendationApp;
    }

    public RecommendationApp getApp() {return this.recommendationApp;}

    public abstract void operate();
}
