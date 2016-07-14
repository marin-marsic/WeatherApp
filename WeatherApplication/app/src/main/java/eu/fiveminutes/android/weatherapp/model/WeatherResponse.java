package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class WeatherResponse {

    @SerializedName("city")
    private City city;

    @SerializedName("cod")
    private String code;

    @SerializedName("message")
    private String message;

    @SerializedName("list")
    private List<Weather> days;

    public City getCity() {
        return city;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<Weather> getDays() {
        return days;
    }
}
