package eu.fiveminutes.android.weatherapp.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public final class JSONWeatherParserImpl implements JSONWeatherParser {

    public WeatherResponse getWeather(String jsonData) {
        Gson gson = new GsonBuilder().create();
        try {
            WeatherResponse response = gson.fromJson(jsonData, WeatherResponse.class);
            return response;
        } catch (JsonSyntaxException e) {
            return null;
        }
    }
}
