package eu.fiveminutes.android.weatherapp.dagger2;


import android.app.Activity;

public class ComponentFactory {

    private ComponentFactory() {}

    public static ApplicationComponent createApplicationComponent(WeatherApplication weatherApplication) {
        return ApplicationComponent.Initializer.init(weatherApplication);
    }

    public static ActivityComponent createActivityComponent(WeatherApplication weatherApplication, Activity activity) {
        return ActivityComponent.Initializer.init(weatherApplication.getApplicationComponent(), activity);
    }
}
