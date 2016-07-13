package eu.fiveminutes.android.weatherapp.model;


public final class Temperature {

    public final int tempMin;
    public final int tempMax;
    public final int tempCurrent;

    public Temperature(final int tempMin, final int tempMax, final int tempCurrent) {
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.tempCurrent = tempCurrent;
    }
}
