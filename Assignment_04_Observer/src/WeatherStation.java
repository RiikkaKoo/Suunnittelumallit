public class WeatherStation extends Observable implements Runnable {

    private double currentTemp;
    private double minTemp = -50;
    private double maxTemp = 60;

    public WeatherStation() {
        this.currentTemp = (double) (Math.random() * (this.maxTemp - this.minTemp)) + this.minTemp; // Set a random temperature as the starting temperature.
    }

    // Method for the observers to get the current state of the observable
    public double getTemperature() {
        return this.currentTemp;
    }

    // Raise or lower the temperature (-1.5 - 1.5) and check that it does not go past the min or max temperatures.
    private void updateTemp() {
        double tempChange = (Math.random() * (1.5 - (-1.5))) + (-1.5);
        this.currentTemp += tempChange;
        if (currentTemp > this.maxTemp) currentTemp = maxTemp;
        else if (currentTemp < this.minTemp) currentTemp = minTemp;
    }

    // The thread loop:
    @Override
    public void run() {
        try {
            while (true) {
                updateTemp(); // Update the temperature.
                System.out.println("\n\n");
                notifyObservers(); // Tell the observers to get the updated state and print out the data.
                Thread.sleep((int)(Math.random() * (5000 - 1000)) + 1000); // Sleep for 5 to 10 seconds and repeat.
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
