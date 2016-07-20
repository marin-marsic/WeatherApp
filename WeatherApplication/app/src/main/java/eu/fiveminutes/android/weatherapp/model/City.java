package eu.fiveminutes.android.weatherapp.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public final class City implements Parcelable {

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

    public City(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.country = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(country);
    }

    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public City createFromParcel(Parcel in) {
                    return new City(in);
                }

                public City[] newArray(int size) {
                    return new City[size];
                }
            };
}
