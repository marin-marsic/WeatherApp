package eu.fiveminutes.android.weatherapp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.fiveminutes.android.weatherapp.R;
import eu.fiveminutes.android.weatherapp.model.Weather;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public final class WeatherDetailsActivity extends Activity {

    private static final String DATA = "data";
    private static final int TODAY = 0;
    private static final int FIRST = 0;


    @BindView(R.id.header)
    TextView header;

    @BindView(R.id.icon)
    ImageView imageView;

    @BindView(R.id.shortDescription)
    TextView shortDescription;

    @BindView(R.id.longDescription)
    TextView longDescription;

    @BindView(R.id.humidity)
    TextView humidity;

    @BindView(R.id.clouds)
    TextView clouds;

    @BindView(R.id.temperature)
    TextView temperature;

    @BindView(R.id.wind)
    TextView wind;

    @BindView(R.id.pressure)
    TextView pressure;

    @BindView(R.id.listview)
    ListView listview;

    private WeatherDetailsAdapter weatherDetailsAdapter;


    public static Intent newIntent(final Context context, final WeatherResponse weatherResponse) {
        Intent intent = new Intent(context, WeatherDetailsActivity.class);
        intent.putExtra(DATA, weatherResponse);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        showContent();
    }

    private void setHeader(final WeatherResponse weatherResponse, final DataRenderUtil renderUtil) {
        header.setText(weatherResponse.city.name);
        Picasso.with(this)
                .load(renderUtil.getImageURL(weatherResponse.days.get(TODAY).descriptionList.get(FIRST).imageID))
                .into(imageView);
    }

    private void showWeatherStats(final WeatherResponse weatherResponse, final DataRenderUtil renderUtil) {
        final Weather today = weatherResponse.days.get(TODAY);

        shortDescription.setText(today.descriptionList.get(FIRST).shortDescription);
        longDescription.setText(today.descriptionList.get(FIRST).longDescription);

        temperature.setText(renderUtil.getTemperatureString(today.temperature.day));
        humidity.setText(renderUtil.getHumidityString(today.humidity));
        wind.setText(renderUtil.getWindString(today.windSpeed));
        clouds.setText(renderUtil.getCloudnessString(today.clouds));
        pressure.setText(renderUtil.getPressureString(today.pressure));
    }

    private void setForecastList(final WeatherResponse weatherResponse) {
        final ArrayList<Weather> days = new ArrayList<>(weatherResponse.days);
        days.remove(TODAY);

        weatherDetailsAdapter = new WeatherDetailsAdapter(this, days);
        listview.setAdapter(weatherDetailsAdapter);
    }

    private void showContent() {

        final WeatherResponse weatherResponse = getIntent().getExtras().getParcelable(DATA);
        final DataRenderUtil renderUtil = new DataRenderUtil();

        setHeader(weatherResponse, renderUtil);

        showWeatherStats(weatherResponse, renderUtil);

        setForecastList(weatherResponse);
    }
}
