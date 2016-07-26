package eu.fiveminutes.android.weatherapp.presenter;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;

import eu.fiveminutes.android.weatherapp.config.Config;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherService;
import eu.fiveminutes.android.weatherapp.view.WeatherIndexView;
import retrofit2.Callback;

public final class WeatherIndexPresenterImpl implements WeatherIndexPresenter {

    private final WeakReference<WeatherIndexView> weatherIndexViewWeakReference;
    private final OpenWeatherService openWeatherService;

    private final Callback<WeatherResponse> searchCallback;
    private final Callback<WeatherResponse> bulkCallback;

    private final ArrayList<WeatherResponse> responses;

    public WeatherIndexPresenterImpl (final WeatherIndexView weatherIndexView, final OpenWeatherService openWeatherService) {
        this.weatherIndexViewWeakReference = new WeakReference<>(weatherIndexView);
        this.openWeatherService = openWeatherService;
        this.responses = new ArrayList<>();

        this.searchCallback = new CitySearchCallback(this);
        this.bulkCallback = new BulkDataCallback(this);
    }

    @Override
    public void getData() {
        // no bulk downloading available for free account
        // so we fetch the weather info one by one for each city

        final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

        if (weatherIndexView != null) {
            responses.clear();
            weatherIndexView.clearAllCities();

            for (String city : Config.CITIES) {
                openWeatherService.getWeatherForCity(city, bulkCallback);
            }
        }
    }

    @Override
    public void getDataForCity(String city) {
        openWeatherService.getWeatherForCity(city, searchCallback);
    }

    public void onBulkResponse(WeatherResponse weatherResponse) {

        responses.add(weatherResponse);

        if (responses.size() == Config.CITIES.length) {
            Collections.sort(responses, (firstWeatherResponse, secondWeatherResponse) ->
                    firstWeatherResponse.city.name.compareTo(secondWeatherResponse.city.name));

            final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

            if (weatherIndexView != null) {
                weatherIndexView.renderCities(responses);
            }

        }
    }

    @Override
    public void onFailure() {
        final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

        if (weatherIndexView != null) {
            weatherIndexView.clearAllCities();
            weatherIndexView.showErrorMessage();
        }
    }

    @Override
    public void onSearchResponse(WeatherResponse weatherResponse) {
        final WeatherIndexView weatherIndexView = weatherIndexViewWeakReference.get();

        if (weatherIndexView != null) {
            weatherIndexView.showSearchResult(weatherResponse);
        }
    }
}
