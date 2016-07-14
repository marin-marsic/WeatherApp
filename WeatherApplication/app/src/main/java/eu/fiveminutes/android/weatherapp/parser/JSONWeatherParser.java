package eu.fiveminutes.android.weatherapp.parser;


import org.json.JSONArray;
import org.json.JSONObject;

import eu.fiveminutes.android.weatherapp.model.Location;
import eu.fiveminutes.android.weatherapp.model.Temperature;
import eu.fiveminutes.android.weatherapp.model.Weather;
import eu.fiveminutes.android.weatherapp.model.WeatherDescription;
import eu.fiveminutes.android.weatherapp.model.WeatherStats;

public final class JSONWeatherParser implements JSONWeatherParserInterface{

    private static final String CITY = "city";
    private static final String CITY_ID = "id";
    private static final String CITY_NAME = "name";
    private static final String CITY_COUNTRY = "coutry";

    private static final String DAYS_LIST = "list";
    private static final int TODAY = 0;

    private static final String TEMPERATURE = "temp";
    private static final String TEMPERATURE_DAY = "day";
    private static final String TEMPERATURE_MIN = "min";
    private static final String TEMPERATURE_MAX = "max";

    private static final String WEATHER_DESCRIPTION = "weather";
    private static final int FIRST = 0;
    private static final String WEATHER_DESCRIPTION_ID = "id";
    private static final String WEATHER_DESCRIPTION_ICON = "icon";
    private static final String WEATHER_DESCRIPTION_SHORT = "main";
    private static final String WEATHER_DESCRIPTION_LONG = "description";

    private static final String PRESSURE = "pressure";
    private static final String HUMIDITY = "humidity";
    private static final String WIND_SPEED = "speed";
    private static final String CLOUDS = "clouds";

    public Weather getWeather(JSONObject jsonObject) {

        // location info
        final JSONObject locationObject = JSONUtil.getSubNode(CITY, jsonObject);
        final Location location = getLocation(locationObject);

        // get info for today
        final JSONArray days = JSONUtil.getJSONArray(DAYS_LIST, jsonObject);
        final JSONObject todayObject = JSONUtil.getJsonObjectFromJsonArray(TODAY, days);

        // temperature info
        final JSONObject temperatureObject = JSONUtil.getSubNode(TEMPERATURE, todayObject);
        final Temperature temperature = getTemperature(temperatureObject);

        // weather description
        final JSONArray weatherDescriptionArray = JSONUtil.getJSONArray(WEATHER_DESCRIPTION, todayObject);
        final JSONObject weatherDescriptionObject = JSONUtil.getJsonObjectFromJsonArray(FIRST, weatherDescriptionArray);
        final WeatherDescription weatherDescription = getWeatherDescription(weatherDescriptionObject);

        // weather stats
        final WeatherStats weatherStats = getWeatherStats(todayObject);


        return new Weather(location, temperature, weatherStats, weatherDescription);
    }

    public Weather getWeather(String jsonData) {
        return getWeather(JSONUtil.createJsonFromString(jsonData));
    }

    private Location getLocation(JSONObject jsonObject) {

        final String id = JSONUtil.getString(CITY_ID, jsonObject);
        final String city = JSONUtil.getString(CITY_NAME, jsonObject);
        final String country = JSONUtil.getString(CITY_COUNTRY, jsonObject);

        return new Location(id, city, country);
    }

    private Temperature getTemperature(JSONObject jsonObject) {

        final int day = JSONUtil.getInt(TEMPERATURE_DAY, jsonObject);
        final int min = JSONUtil.getInt(TEMPERATURE_MIN, jsonObject);
        final int max = JSONUtil.getInt(TEMPERATURE_MAX, jsonObject);

        return new Temperature(min, max, day);
    }

    private WeatherDescription getWeatherDescription(JSONObject jsonObject) {

        final String id = JSONUtil.getString(WEATHER_DESCRIPTION_ID, jsonObject);
        final String shortDesc = JSONUtil.getString(WEATHER_DESCRIPTION_SHORT, jsonObject);
        final String longDesc = JSONUtil.getString(WEATHER_DESCRIPTION_LONG, jsonObject);
        final String icon = JSONUtil.getString(WEATHER_DESCRIPTION_ICON, jsonObject);

        return new WeatherDescription(id, longDesc, shortDesc, icon);
    }

    private WeatherStats getWeatherStats(JSONObject jsonObject) {

        final int pressure = JSONUtil.getInt(PRESSURE, jsonObject);
        final int humidity = JSONUtil.getInt(HUMIDITY, jsonObject);
        final int windSpeed = JSONUtil.getInt(WIND_SPEED, jsonObject);
        final int cloudness = JSONUtil.getInt(CLOUDS, jsonObject);

        return new WeatherStats(humidity, pressure, windSpeed, cloudness);
    }

}
