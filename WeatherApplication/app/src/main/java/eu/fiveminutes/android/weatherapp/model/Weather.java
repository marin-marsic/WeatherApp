package eu.fiveminutes.android.weatherapp.model;

public final class Weather {

    public final Location location;
    public final Temperature temperature;
    public final WeatherStats weatherStats;
    public final WeatherDescription weatherDescription;

    public Weather(final Location location, final Temperature temperature, final WeatherStats weatherStats, final WeatherDescription weatherDescription) {
        this.location = location;
        this.temperature = temperature;
        this.weatherStats = weatherStats;
        this.weatherDescription = weatherDescription;
    }
}
