package eu.fiveminutes.android.weatherapp.parser;

import org.json.JSONObject;

import eu.fiveminutes.android.weatherapp.model.Weather;

public interface JSONWeatherParserInterface {

    public Weather getWeather(JSONObject jsonObject);
}
