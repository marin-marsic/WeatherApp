package eu.fiveminutes.android.weatherapp.presenter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import eu.fiveminutes.android.weatherapp.config.Config;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherService;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherServiceImpl;
import eu.fiveminutes.android.weatherapp.view.WeatherIndexView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class WeatherIndexPresenterImpl implements WeatherIndexPresenter, Callback<WeatherResponse> {

    private final WeakReference<WeatherIndexView> weatherIndexViewWeakReference;
    private final OpenWeatherService openWeatherService;
    private final ArrayList<WeatherResponse> responses;

    public WeatherIndexPresenterImpl (WeatherIndexView weatherIndexView) {
        this.weatherIndexViewWeakReference = new WeakReference<>(weatherIndexView);
        this.openWeatherService = new OpenWeatherServiceImpl();
        this.responses = new ArrayList<>();
    }

    @Override
    public void getData() {
        // no bulk downloading available for free account
        // so we fetch the weather info one by one for each city

        final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

        if (weatherIndexView != null) {
            weatherIndexView.clearAllCities();

            for (String city : Config.CITIES) {
                openWeatherService.getWeatherForCity(city, this);
            }
        }
    }

    @Override
    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

        responses.add(response.body());

        if (responses.size() == Config.CITIES.length) {
            Collections.sort(responses, new Comparator<WeatherResponse>() {
                @Override
                public int compare(WeatherResponse firstWeatherResponse, WeatherResponse secondWeatherResponse) {
                    return firstWeatherResponse.city.name.compareTo(secondWeatherResponse.city.name);
                }
            });

            final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

            if (weatherIndexView != null) {
                weatherIndexView.renderCities(responses);
            }

        }
    }

    @Override
    public void onFailure(Call<WeatherResponse> call, Throwable t) {
        final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

        if (weatherIndexView != null) {
            weatherIndexView.showErrorMessage();
        }

    }
}
