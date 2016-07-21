package eu.fiveminutes.android.weatherapp.view;


import java.util.ArrayList;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public interface WeatherIndexView {

    void renderCities(final ArrayList<WeatherResponse> responses);

    void clearAllCities();

    void showErrorMessage();

    void showSearchResult(final WeatherResponse weatherResponse);
}
