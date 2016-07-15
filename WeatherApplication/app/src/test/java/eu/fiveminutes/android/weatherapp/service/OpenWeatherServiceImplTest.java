package eu.fiveminutes.android.weatherapp.service;

import org.junit.Test;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;


public class OpenWeatherServiceImplTest {

    private static final double DELTA = 0.001;

    @Test
    public void testGetWeatherRetrofit() throws Exception {

        // test depends on network connection and changing weather
        OpenWeatherService ops = new OpenWeatherServiceImpl();
        ops.getWeatherForCity("Zagreb", new CallbackImplTest());

        // wait for async task
        Thread.sleep(2000);

    }

    private static final class CallbackImplTest implements Callback<WeatherResponse> {
        @Override
        public void onFailure(Call<WeatherResponse> call, Throwable t) {

        }

        @Override
        public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

            WeatherResponse wr = response.body();
            assertEquals("200", wr.code);
            assertEquals("Zagreb", wr.city.name);
            assertEquals("Clouds", wr.days.get(0).descriptionList.get(0).shortDescription);
            assertEquals(16.52, wr.days.get(0).temperature.min, DELTA);
        }
    }
}