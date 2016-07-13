package eu.fiveminutes.android.weatherapp.model;

public final class Location {

    public final String id;
    public final String city;
    public final String country;

    public Location(final String id, final String city, final String country) {
        this.id = id;
        this.city = city;
        this.country = country;
    }
}
