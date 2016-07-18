package eu.fiveminutes.android.weatherapp.service;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherAPI {

    @GET("daily?&units=metric&cnt=7")
    Call<WeatherResponse> load(@Query("q") String city, @Query("appid") String appid);
}
