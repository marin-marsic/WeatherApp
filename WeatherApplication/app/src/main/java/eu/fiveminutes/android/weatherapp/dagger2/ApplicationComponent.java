package eu.fiveminutes.android.weatherapp.dagger2;

import javax.inject.Singleton;

import dagger.Component;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherService;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ApiModule.class
        }
)
public interface ApplicationComponent {

    void inject(WeatherApplication weatherApplication);

    final class Initializer {
        private Initializer() {
        }

        static public ApplicationComponent init(WeatherApplication weatherApplication) {
            return DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(weatherApplication))
                    .build();
        }
    }

    OpenWeatherService openWeatherService();
}
