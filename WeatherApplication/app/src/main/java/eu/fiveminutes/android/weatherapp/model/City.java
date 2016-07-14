package eu.fiveminutes.android.weatherapp.model;


import com.google.gson.annotations.SerializedName;

public final class City {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("country")
    private String country;

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
