package eu.fiveminutes.android.weatherapp.presenter;


import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BulkDataCallback implements Callback<WeatherResponse> {

    private final WeatherIndexPresenter weatherIndexPresenter;

    public BulkDataCallback(final WeatherIndexPresenter weatherIndexPresenter) {
        this.weatherIndexPresenter = weatherIndexPresenter;
    }

    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
        weatherIndexPresenter.onBulkResponse(response.body());
    }

    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        weatherIndexPresenter.onFailure();
    }
}
