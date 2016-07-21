package eu.fiveminutes.android.weatherapp.presenter;



import java.lang.ref.WeakReference;

import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherService;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherServiceImpl;
import eu.fiveminutes.android.weatherapp.view.WeatherIndexView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class CitySearchPresenterImpl implements CitySearchPresenter, Callback<WeatherResponse> {

    private final WeakReference<WeatherIndexView> weatherIndexViewWeakReference;
    private final OpenWeatherService openWeatherService;

    public CitySearchPresenterImpl(final WeatherIndexView weatherIndexView) {
        this.weatherIndexViewWeakReference = new WeakReference<>(weatherIndexView);
        this.openWeatherService = new OpenWeatherServiceImpl();
    }

    @Override
    public void getDataForCity(String city) {
        openWeatherService.getWeatherForCity(city, this);
    }

    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
        final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

        if (weatherIndexView != null) {
            weatherIndexView.showSearchResult(response.body());
        }
    }

    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

        if (weatherIndexView != null) {
            weatherIndexView.clearAllCities();
            weatherIndexView.showErrorMessage();
        }
    }
}
