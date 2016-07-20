package eu.fiveminutes.android.weatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class WeatherResponse  implements Parcelable {

    @SerializedName("city")
    public final City city;

    @SerializedName("cod")
    public final String code;

    @SerializedName("message")
    public final String message;

    @SerializedName("list")
    public List<Weather> days = new ArrayList<>();

    public WeatherResponse(final City city, final String code, final String message, final List<Weather> days) {
        this.city = city;
        this.code = code;
        this.message = message;
        this.days = days;
    }

    public WeatherResponse(Parcel in) {
        this.city = in.readParcelable(City.class.getClassLoader());
        this.code = in.readString();
        this.message = in.readString();
        in.readTypedList(days, Weather.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(city, i);
        parcel.writeString(code);
        parcel.writeString(message);
        parcel.writeTypedList(days);
    }

    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public WeatherResponse createFromParcel(Parcel in) {
                    return new WeatherResponse(in);
                }

                public WeatherResponse[] newArray(int size) {
                    return new WeatherResponse[size];
                }
            };
}
