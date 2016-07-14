package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Weather {

    @SerializedName("temp")
    private Temperature temperature;

    @SerializedName("pressure")
    private double pressure;

    @SerializedName("humidity")
    private double humidity;

    @SerializedName("speed")
    private double windSpeed;

    @SerializedName("clouds")
    private double clouds;

    @SerializedName("weather")
    private List<WeatherDescription> descriptionList;

    public Temperature getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getClouds() {
        return clouds;
    }

    public List<WeatherDescription> getDescriptionList() {
        return descriptionList;
    }
}
