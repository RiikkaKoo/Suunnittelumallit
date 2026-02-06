public class ObservingSystem implements Observer {

    private WeatherStation station;
    private String systemName;

    public ObservingSystem(WeatherStation weatherStation, String name) {
        this.station = weatherStation;
        this.systemName = name;
    }

    @Override
    public void update() {
        System.out.println(this.systemName + " received update from the weather station. Current temperature is " +
                String.format("%.2f", this.station.getTemperature()) + " °C");


    }
}
