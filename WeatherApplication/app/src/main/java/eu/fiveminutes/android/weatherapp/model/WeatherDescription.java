package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

public final class WeatherDescription {

    @SerializedName("id")
    public final String id;

    @SerializedName("main")
    public final String shortDescription;

    @SerializedName("description")
    public final String longDescription;

    @SerializedName("icon")
    public final String imageIcon;

    public WeatherDescription(final String id, final String shortDescription, final String longDescription, final String imageIcon) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.imageIcon = imageIcon;
    }
}
