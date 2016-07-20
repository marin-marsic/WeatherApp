package eu.fiveminutes.android.weatherapp.view;


import eu.fiveminutes.android.weatherapp.config.Config;

public final class DataRenderUtil {

    private static final String TEMPERATURE_UNIT = "°C";

    private static final String HUMIDITY_UNIT = "%";

    private static final String WIND_UNIT = "m/s";

    private static final String CLOUDNESS_UNIT = "%";

    private static final String PRESSURE_UNIT = "hPa";

    private static final String IMG_EXTENSION = ".png";


    public String doubleToIntString(final double number) {
        return Integer.toString((int) Math.round(number));
    }

    public String getTemperatureString(final double temperature) {
        return doubleToIntString(temperature) + TEMPERATURE_UNIT;
    }

    public String getHumidityString(final double temperature) {
        return doubleToIntString(temperature) + HUMIDITY_UNIT;
    }

    public String getWindString(final double temperature) {
        return doubleToIntString(temperature) + WIND_UNIT;
    }

    public String getCloudnessString(final double temperature) {
        return doubleToIntString(temperature) + CLOUDNESS_UNIT;
    }

    public String getPressureString(final double temperature) {
        return doubleToIntString(temperature) + PRESSURE_UNIT;
    }

    public String getImageURL(final String imageID) {
        return Config.IMAGE_URL + imageID + IMG_EXTENSION;
    }
}
