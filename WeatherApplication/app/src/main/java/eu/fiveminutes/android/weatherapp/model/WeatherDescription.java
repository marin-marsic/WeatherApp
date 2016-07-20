package eu.fiveminutes.android.weatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public final class WeatherDescription implements Parcelable {

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

    public WeatherDescription(Parcel in) {
        this.id = in.readString();
        this.shortDescription = in.readString();
        this.longDescription = in.readString();
        this.imageID = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(shortDescription);
        parcel.writeString(longDescription);
        parcel.writeString(imageID);
    }

    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public WeatherDescription createFromParcel(Parcel in) {
                    return new WeatherDescription(in);
                }

                public WeatherDescription[] newArray(int size) {
                    return new WeatherDescription[size];
                }
            };
}
