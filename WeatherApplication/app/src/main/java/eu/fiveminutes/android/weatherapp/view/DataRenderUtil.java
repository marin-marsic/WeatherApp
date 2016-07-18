package eu.fiveminutes.android.weatherapp.view;


import eu.fiveminutes.android.weatherapp.config.Config;

public final class DataRenderUtil {

    public String DoubleToIntString(final double number) {
        return Integer.toString((int) Math.round(number));
    }

    public String getImageURL(final String imageID) {
        return Config.IMAGE_URL + imageID + ".png";
    }
}
