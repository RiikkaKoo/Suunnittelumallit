public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        Thread t = new Thread(weatherStation);

        Observer firstSystem = new ObservingSystem(weatherStation, "First Observing System");
        Observer secondSystem = new ObservingSystem(weatherStation, "Second Observing System");
        Observer thirdSystem = new ObservingSystem(weatherStation, "Third Observing System");

        weatherStation.addObserver(firstSystem);
        weatherStation.addObserver(secondSystem);
        weatherStation.addObserver(thirdSystem);

        t.start();

        try {
            Thread.sleep((int)(12000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        weatherStation.removeObserver(firstSystem);
    }
}
