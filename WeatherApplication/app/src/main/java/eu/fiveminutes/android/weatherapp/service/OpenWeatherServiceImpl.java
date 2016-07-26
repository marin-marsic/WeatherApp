package eu.fiveminutes.android.weatherapp.service;


import eu.fiveminutes.android.weatherapp.config.Config;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public final class OpenWeatherServiceImpl implements OpenWeatherService{

    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private final OpenWeatherAPI openWeatherAPI;

    public OpenWeatherServiceImpl(Retrofit retrofit) {
        openWeatherAPI = retrofit.create(OpenWeatherAPI.class);
    }

    @Override
    public void getWeatherForCity(String city, Callback<WeatherResponse> callback) {
        final String key = Config.API_KEY;
        final Call<WeatherResponse> call = openWeatherAPI.load(city, key);
        call.enqueue(callback);
    }
}
