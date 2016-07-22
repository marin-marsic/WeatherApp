package eu.fiveminutes.android.weatherapp.presenter;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public final class CitySearchCallback implements Callback<WeatherResponse> {

    private final WeatherIndexPresenter weatherIndexPresenter;

    public CitySearchCallback(final WeatherIndexPresenter weatherIndexPresenter) {
        this.weatherIndexPresenter = weatherIndexPresenter;
    }

    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
        weatherIndexPresenter.onSearchResponse(response.body());
    }

    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        weatherIndexPresenter.onFailure();
    }
}
