package eu.fiveminutes.android.weatherapp.parser;


import org.json.JSONArray;
import org.json.JSONObject;

import eu.fiveminutes.android.weatherapp.model.Location;
import eu.fiveminutes.android.weatherapp.model.Temperature;
import eu.fiveminutes.android.weatherapp.model.Weather;
import eu.fiveminutes.android.weatherapp.model.WeatherDescription;
import eu.fiveminutes.android.weatherapp.model.WeatherStats;

public class JSONWeatherParser {

    public static final String CITY = "city";
    public static final String CITY_ID = "id";
    public static final String CITY_NAME = "name";
    public static final String CITY_COUNTRY = "coutry";

    public static final String DAYS_LIST = "list";
    public static final int TODAY = 0;

    public static final String TEMPERATURE = "temp";
    public static final String TEMPERATURE_DAY = "day";
    public static final String TEMPERATURE_MIN = "min";
    public static final String TEMPERATURE_MAX = "max";

    public static final String WEATHER_DESCRIPTION = "weather";
    public static final int FIRST = 0;
    public static final String WEATHER_DESCRIPTION_ID = "id";
    public static final String WEATHER_DESCRIPTION_ICON = "icon";
    public static final String WEATHER_DESCRIPTION_SHORT = "main";
    public static final String WEATHER_DESCRIPTION_LONG = "description";

    public static final String PRESSURE = "pressure";
    public static final String HUMIDITY = "humidity";
    public static final String WIND_SPEED = "speed";
    public static final String CLOUDS = "clouds";

    public Weather getWeather(JSONObject jsonObject) {

        // location info
        JSONObject locationObject = JSONUtil.getSubNode(CITY, jsonObject);
        Location location = getLocation(locationObject);

        // get info for today
        JSONArray days = JSONUtil.getJSONArray(DAYS_LIST, jsonObject);
        JSONObject todayObject = JSONUtil.getJsonObjectFromJsonArray(TODAY, days);

        // temperature info
        JSONObject temperatureObject = JSONUtil.getSubNode(TEMPERATURE, todayObject);
        Temperature temperature = getTemperature(temperatureObject);

        // weather description
        JSONArray weatherDescriptionArray = JSONUtil.getJSONArray(WEATHER_DESCRIPTION, todayObject);
        JSONObject weatherDescriptionObject = JSONUtil.getJsonObjectFromJsonArray(FIRST, weatherDescriptionArray);
        WeatherDescription weatherDescription = getWeatherDescription(weatherDescriptionObject);

        // weather stats
        WeatherStats weatherStats = getWeatherStats(todayObject);


        Weather weather = new Weather(location, temperature, weatherStats, weatherDescription);
        return weather;
    }

    public Weather getWeather(String jsonData) {
        return getWeather(JSONUtil.createJsonFromString(jsonData));
    }

    private Location getLocation(JSONObject jsonObject) {

        String id = JSONUtil.getString(CITY_ID, jsonObject);
        String city = JSONUtil.getString(CITY_NAME, jsonObject);
        String country = JSONUtil.getString(CITY_COUNTRY, jsonObject);

        Location location = new Location(id, city, country);
        return location;
    }

    private Temperature getTemperature(JSONObject jsonObject) {

        int day = JSONUtil.getInt(TEMPERATURE_DAY, jsonObject);
        int min = JSONUtil.getInt(TEMPERATURE_MIN, jsonObject);
        int max = JSONUtil.getInt(TEMPERATURE_MAX, jsonObject);

        Temperature temperature = new Temperature(min, max, day);
        return temperature;
    }

    private WeatherDescription getWeatherDescription(JSONObject jsonObject) {

        String id = JSONUtil.getString(WEATHER_DESCRIPTION_ID, jsonObject);
        String shortDesc = JSONUtil.getString(WEATHER_DESCRIPTION_SHORT, jsonObject);
        String longDesc = JSONUtil.getString(WEATHER_DESCRIPTION_LONG, jsonObject);
        String icon = JSONUtil.getString(WEATHER_DESCRIPTION_ICON, jsonObject);

        WeatherDescription weatherDescription = new WeatherDescription(id, longDesc, shortDesc, icon);
        return weatherDescription;
    }

    private WeatherStats getWeatherStats(JSONObject jsonObject) {

        int pressure = JSONUtil.getInt(PRESSURE, jsonObject);
        int humidity = JSONUtil.getInt(HUMIDITY, jsonObject);
        int windSpeed = JSONUtil.getInt(WIND_SPEED, jsonObject);
        int cloudness = JSONUtil.getInt(CLOUDS, jsonObject);

        WeatherStats weatherStats = new WeatherStats(humidity, pressure, windSpeed, cloudness);
        return weatherStats;
    }

}
