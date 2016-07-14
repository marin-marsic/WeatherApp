package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public final class WeatherDescription {

    @SerializedName("id")
    private String id;

    @SerializedName("main")
    private String shortDescription;

    @SerializedName("description")
    private String longDescription;

    @SerializedName("icon")
    private String imageIcon;

    public String getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getImageIcon() {
        return imageIcon;
    }
}
