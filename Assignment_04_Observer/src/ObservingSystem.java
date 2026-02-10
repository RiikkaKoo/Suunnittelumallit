public class ObservingSystem implements Observer {

    private WeatherStation station;
    private String systemName;

    // Add the weather station as a private attribute to get its updated state when needed.
    public ObservingSystem(WeatherStation weatherStation, String name) {
        this.station = weatherStation; // The observable
        this.systemName = name;
    }

    // Print the update with this systems name when the weather station calls this method.
    @Override
    public void update() {
        System.out.println(this.systemName + " received update from the weather station. Current temperature is " +
                String.format("%.2f", this.station.getTemperature()) + " °C");


    }
}
