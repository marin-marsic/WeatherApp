package eu.fiveminutes.android.weatherapp.service;


import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import retrofit2.Callback;

public interface OpenWeatherService {

    void getWeatherForCity(final String city, final Callback<WeatherResponse> callback);
}
