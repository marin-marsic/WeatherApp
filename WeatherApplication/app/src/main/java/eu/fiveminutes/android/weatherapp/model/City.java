package eu.fiveminutes.android.weatherapp.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public final class City implements Serializable {

    @SerializedName("id")
    public final String id;

    @SerializedName("name")
    public final String name;

    @SerializedName("country")
    public final String country;

    public City(final String id, final String name, final String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
