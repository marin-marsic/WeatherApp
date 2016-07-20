package eu.fiveminutes.android.weatherapp.parser;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public interface JSONWeatherParser {

    WeatherResponse getWeather(String jsonObject);
}
