package eu.fiveminutes.android.weatherapp.parser;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public interface JSONWeatherParser {

    public WeatherResponse getWeather(String jsonObject);
}
