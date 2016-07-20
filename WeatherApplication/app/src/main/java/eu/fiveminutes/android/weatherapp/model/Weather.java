package eu.fiveminutes.android.weatherapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class Weather  implements Parcelable {

    @SerializedName("temp")
    public final Temperature temperature;

    @SerializedName("pressure")
    public final double pressure;

    @SerializedName("humidity")
    public final double humidity;

    @SerializedName("speed")
    public final double windSpeed;

    @SerializedName("clouds")
    public final double clouds;

    @SerializedName("weather")
    public List<WeatherDescription> descriptionList = new ArrayList<>();

    public Weather(final Temperature temperature, final double pressure, final double humidity, final double windSpeed, final double clouds, final List<WeatherDescription> descriptionList) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.clouds = clouds;
        this.descriptionList = descriptionList;
    }

    public Weather(Parcel in) {
        this.temperature = in.readParcelable(Temperature.class.getClassLoader());
        this.pressure = in.readDouble();
        this.humidity = in.readDouble();
        this.windSpeed = in.readDouble();
        this.clouds = in.readDouble();
        in.readTypedList(descriptionList, WeatherDescription.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(temperature, i);
        parcel.writeDouble(pressure);
        parcel.writeDouble(humidity);
        parcel.writeDouble(windSpeed);
        parcel.writeDouble(clouds);
        parcel.writeTypedList(descriptionList);

    }

    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public Weather createFromParcel(Parcel in) {
                    return new Weather(in);
                }

                public Weather[] newArray(int size) {
                    return new Weather[size];
                }
            };
}
