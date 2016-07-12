package eu.fiveminutes.android.weatherapp.model;

public class Weather {

    private Location location;

    private String weatherID;
    private String longDescription;
    private String shortDescription;
    private String iconId;

    private int tempMin;
    private int tempMax;
    private int tempCurrent;

    private int humidity;
    private int pressure;
    private int windSpeed;
    private int cloudness;


    public Location getLocation() {
        return location;
    }


    public void setLocation(Location location) {
        this.location = location;
    }


    public String getWeatherID() {
        return weatherID;
    }


    public void setWeatherID(String weatherID) {
        this.weatherID = weatherID;
    }


    public String getLongDescription() {
        return longDescription;
    }


    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }


    public String getShortDescription() {
        return shortDescription;
    }


    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }


    public String getIconId() {
        return iconId;
    }


    public void setIconId(String iconId) {
        this.iconId = iconId;
    }


    public int getTempMin() {
        return tempMin;
    }


    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }


    public int getTempMax() {
        return tempMax;
    }


    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }


    public int getTempCurrent() {
        return tempCurrent;
    }


    public void setTempCurrent(int tempCurrent) {
        this.tempCurrent = tempCurrent;
    }


    public int getHumidity() {
        return humidity;
    }


    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }


    public int getPressure() {
        return pressure;
    }


    public void setPressure(int pressure) {
        this.pressure = pressure;
    }


    public int getWindSpeed() {
        return windSpeed;
    }


    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }


    public int getCloudness() {
        return cloudness;
    }


    public void setCloudness(int cloudness) {
        this.cloudness = cloudness;
    }
}
