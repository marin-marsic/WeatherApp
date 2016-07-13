package eu.fiveminutes.android.weatherapp.model;


public final class WeatherDescription {

    public final String weatherID;
    public final String longDescription;
    public final String shortDescription;
    public final String iconId;

    public WeatherDescription(final String weatherID, final String longDescription, final String shortDescription, final String iconId) {
        this.weatherID = weatherID;
        this.longDescription = longDescription;
        this.shortDescription = shortDescription;
        this.iconId = iconId;
    }
}
