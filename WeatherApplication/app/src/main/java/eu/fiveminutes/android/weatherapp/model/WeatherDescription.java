package eu.fiveminutes.android.weatherapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public final class WeatherDescription  implements Serializable {

    @SerializedName("id")
    public final String id;

    @SerializedName("main")
    public final String shortDescription;

    @SerializedName("description")
    public final String longDescription;

    @SerializedName("icon")
    public final String imageID;

    public WeatherDescription(final String id, final String shortDescription, final String longDescription, final String imageID) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.imageID = imageID;
    }
}
