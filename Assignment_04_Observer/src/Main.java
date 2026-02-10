public class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        // The weather station works in its own thread:
        Thread t = new Thread(weatherStation);

        Observer firstSystem = new ObservingSystem(weatherStation, "First Observing System");
        Observer secondSystem = new ObservingSystem(weatherStation, "Second Observing System");
        Observer thirdSystem = new ObservingSystem(weatherStation, "Third Observing System");

        // Observing systems observe the weather station:
        weatherStation.addObserver(firstSystem);
        weatherStation.addObserver(secondSystem);
        weatherStation.addObserver(thirdSystem);

        // Start the weather station:
        t.start();

        // Sleep for 15 seconds and the remove the first observer.
        // The weather station keeps updating while main program sleeps and the observers will print out the updates.
        try {
            Thread.sleep((int)(15000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        weatherStation.removeObserver(firstSystem);
    }
}
