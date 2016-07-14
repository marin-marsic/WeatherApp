package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public final class Temperature {

    @SerializedName("min")
    public final double min;

    @SerializedName("max")
    public final double max;

    @SerializedName("day")
    public final double day;

    public Temperature(final double min, final double max, final double day) {
        this.min = min;
        this.max = max;
        this.day = day;
    }
}