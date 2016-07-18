package eu.fiveminutes.android.weatherapp.service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import eu.fiveminutes.android.weatherapp.config.Config;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class OpenWeatherServiceImpl implements OpenWeatherService{

    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssZ";
    private final OpenWeatherAPI openWeatherAPI;

    public OpenWeatherServiceImpl() {
        final Gson gson = new GsonBuilder()
                .setDateFormat(DATE_FORMAT)
                .create();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        openWeatherAPI = retrofit.create(OpenWeatherAPI.class);
    }

    @Override
    public void getWeatherForCity(String city, Callback<WeatherResponse> callback) {
        final String key = Config.API_KEY;
        final Call<WeatherResponse> call = openWeatherAPI.load(city, key);
        call.enqueue(callback);
    }
}
