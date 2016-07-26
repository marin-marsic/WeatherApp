package eu.fiveminutes.android.weatherapp.dagger2;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public final class ApplicationModule {

    private final WeatherApplication weatherApplication;

    public ApplicationModule(final WeatherApplication weatherApplication) {
        this.weatherApplication = weatherApplication;
    }

    @Provides
    @Singleton
    WeatherApplication provideApplication() {
        return weatherApplication;
    }
}
