package eu.fiveminutes.android.weatherapp.presenter;


import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public interface WeatherIndexPresenter {

    void getData();

    void getDataForCity(final String city);

    void onSearchResponse(WeatherResponse weatherResponse);

    void onBulkResponse(WeatherResponse weatherResponse);

    void onFailure();
}
