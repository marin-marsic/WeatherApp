package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public final class WeatherResponse  implements Serializable {

    @SerializedName("city")
    public final City city;

    @SerializedName("cod")
    public final String code;

    @SerializedName("message")
    public final String message;

    @SerializedName("list")
    public final List<Weather> days;

    public WeatherResponse(final City city, final String code, final String message, final List<Weather> days) {
        this.city = city;
        this.code = code;
        this.message = message;
        this.days = days;
    }
}
