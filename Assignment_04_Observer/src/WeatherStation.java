public class WeatherStation extends Observable implements Runnable {

    private double currentTemp;
    private double minTemp = -50;
    private double maxTemp = 60;

    public WeatherStation() {
        this.currentTemp = (double) (Math.random() * (this.maxTemp - this.minTemp)) + this.minTemp;

    }

    public double getTemperature() {
        return this.currentTemp;
    }

    private void updateTemp() {
        double tempChange = (Math.random() * (1.5 - (-1.5))) + (-1.5);
        this.currentTemp += tempChange;
        if (currentTemp > this.maxTemp) currentTemp = maxTemp;
        else if (currentTemp < this.minTemp) currentTemp = minTemp;
    }

    @Override
    public void run() {
        try {
            while (true) {
                updateTemp();
                System.out.println("\n\n");
                notifyObservers();
                Thread.sleep((int)(Math.random() * (5000 - 1000)) + 1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
            return;
        }
    }
}
