package eu.fiveminutes.android.weatherapp.model;


public final class WeatherStats {

    public final int humidity;
    public final int pressure;
    public final int windSpeed;
    public final int cloudness;

    public WeatherStats(final int humidity, final int pressure, final int windSpeed, final int cloudness) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.cloudness = cloudness;
    }
}
