package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public final class Weather  implements Serializable {

    @SerializedName("temp")
    public final Temperature temperature;

    @SerializedName("pressure")
    public final double pressure;

    @SerializedName("humidity")
    public final double humidity;

    @SerializedName("speed")
    public final double windSpeed;

    @SerializedName("clouds")
    public final double clouds;

    @SerializedName("weather")
    public final List<WeatherDescription> descriptionList;

    public Weather(final Temperature temperature, final double pressure, final double humidity, final double windSpeed, final double clouds, final List<WeatherDescription> descriptionList) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.descriptionList = descriptionList;
    }
}
