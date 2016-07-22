package eu.fiveminutes.android.weatherapp.dagger2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import eu.fiveminutes.android.weatherapp.config.Config;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherService;
import eu.fiveminutes.android.weatherapp.service.OpenWeatherServiceImpl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public final class ApiModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat(OpenWeatherServiceImpl.DATE_FORMAT)
                .create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(Config.API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    OpenWeatherService provideOpenWeatherService(Retrofit retrofit) {
        return new OpenWeatherServiceImpl(retrofit);
    }
}
