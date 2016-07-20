package eu.fiveminutes.android.weatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public final class Temperature implements Parcelable {

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

    public Temperature(Parcel in) {
        this.min = in.readDouble();
        this.max = in.readDouble();
        this.day = in.readDouble();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(min);
        parcel.writeDouble(max);
        parcel.writeDouble(day);
    }

    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public Temperature createFromParcel(Parcel in) {
                    return new Temperature(in);
                }

                public Temperature[] newArray(int size) {
                    return new Temperature[size];
                }
            };
}