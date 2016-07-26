package eu.fiveminutes.android.weatherapp.dagger2;

import android.app.Activity;

import dagger.Component;
import eu.fiveminutes.android.weatherapp.view.WeatherDetailsActivity;
import eu.fiveminutes.android.weatherapp.view.WeatherIndexActivity;

@ActivityScope
@Component(
        dependencies = {
                ApplicationComponent.class
        },
        modules = {
                ActivityModule.class
        }
)
public interface ActivityComponent {

    void injectIndex(WeatherIndexActivity weatherIndexActivity);

    void injectDetails(WeatherDetailsActivity weatherDetailsActivity);

    final class Initializer {
        private Initializer() {
        }

        static public ActivityComponent init(ApplicationComponent applicationComponent, Activity activity) {
            return DaggerActivityComponent.builder()
                    .applicationComponent(applicationComponent)
                    .activityModule(new ActivityModule(activity))
                    .build();
        }
    }

}
