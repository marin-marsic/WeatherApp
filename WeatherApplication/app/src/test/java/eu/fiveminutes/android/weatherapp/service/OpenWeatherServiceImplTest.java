package eu.fiveminutes.android.weatherapp.service;

import org.junit.Test;

import javax.inject.Inject;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;


public class OpenWeatherServiceImplTest {

    private static final double DELTA = 0.001;

    @Inject
    OpenWeatherService openWeatherService;

    @Test
    public void testGetWeatherRetrofit() throws Exception {

        // test depends on network connection and changing weather
        openWeatherService.getWeatherForCity("Zagreb", new CallbackImplTest());

        // wait for async task
        Thread.sleep(2000);

    }

    private static final class CallbackImplTest implements Callback<WeatherResponse> {
        @Override
        public void onFailure(Call<WeatherResponse> call, Throwable t) {

        }

        @Override
        public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

            final WeatherResponse weatherResponse = response.body();
            assertEquals("200", weatherResponse.code);
        }
    }
}