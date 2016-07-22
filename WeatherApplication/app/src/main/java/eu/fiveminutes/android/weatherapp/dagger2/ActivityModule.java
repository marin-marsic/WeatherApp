package eu.fiveminutes.android.weatherapp.dagger2;

import android.app.Activity;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import eu.fiveminutes.android.weatherapp.presenter.WeatherIndexPresenter;
import eu.fiveminutes.android.weatherapp.presenter.WeatherIndexPresenterImpl;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherService;
import eu.fiveminutes.android.weatherapp.view.WeatherArrayAdapter;
import eu.fiveminutes.android.weatherapp.view.WeatherDetailsAdapter;
import eu.fiveminutes.android.weatherapp.view.WeatherIndexView;

@Module
public final class ActivityModule {

    private final Activity activity;

    public ActivityModule(final Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    WeatherIndexPresenter provideWeatherIndexPresenter(OpenWeatherService openWeatherService) {
        if (activity instanceof WeatherIndexView) {
            return new WeatherIndexPresenterImpl((WeatherIndexView) activity, openWeatherService);
        } else {
            throw new IllegalArgumentException("Provided Activity is not instance of WeatherIndexView.");
        }
    }

    @Provides
    @ActivityScope
    WeatherArrayAdapter provideWeatherArrayAdapter() {
        return new WeatherArrayAdapter(activity, new ArrayList<>());
    }

    @Provides
    @ActivityScope
    WeatherDetailsAdapter provideWeatherDetailsAdapter() {
        return new WeatherDetailsAdapter(activity, new ArrayList<>());
    }

}
