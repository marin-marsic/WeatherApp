package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public final class Temperature {

    @SerializedName("min")
    private double min;

    @SerializedName("max")
    private double max;

    @SerializedName("day")
    private double day;

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getDay() {
        return day;
    }
}