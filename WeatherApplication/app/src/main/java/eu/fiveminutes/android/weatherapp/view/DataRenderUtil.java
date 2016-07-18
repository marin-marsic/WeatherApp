package eu.fiveminutes.android.weatherapp.view;


import eu.fiveminutes.android.weatherapp.config.Config;

public final class DataRenderUtil {

    private static final String TEMPERATURE = "Temperature: ";
    private static final String TEMPERATURE_UNIT = "°C";

    private static final String HUMIDITY = "Humidity: ";
    private static final String HUMIDITY_UNIT = "%";

    private static final String WIND = "Wind: ";
    private static final String WIND_UNIT = "m/s";

    private static final String CLOUDNESS = "Cloudness: ";
    private static final String CLOUDNESS_UNIT = "%";

    private static final String PRESSURE = "Pressure: ";
    private static final String PRESSURE_UNIT = "hPa";


    public String doubleToIntString(final double number) {
        return Integer.toString((int) Math.round(number));
    }

    public String getTemperatureString(final double temperature) {
        return TEMPERATURE + doubleToIntString(temperature) + TEMPERATURE_UNIT;
    }

    public String getHumidityString(final double temperature) {
        return HUMIDITY + doubleToIntString(temperature) + HUMIDITY_UNIT;
    }

    public String getWindString(final double temperature) {
        return WIND + doubleToIntString(temperature) + WIND_UNIT;
    }

    public String getCloudnessString(final double temperature) {
        return CLOUDNESS + doubleToIntString(temperature) + CLOUDNESS_UNIT;
    }

    public String getPressureString(final double temperature) {
        return PRESSURE + doubleToIntString(temperature) + PRESSURE_UNIT;
    }

    public String getImageURL(final String imageID) {
        return Config.IMAGE_URL + imageID + ".png";
    }
}
