package eu.fiveminutes.android.weatherapp.view;

import android.app.Activity;
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

public final class DetailsActivity extends Activity {

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

    private static final int TODAY = 0;

    private DetailsArrayAdapter detailsArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        final WeatherResponse weatherResponse = (WeatherResponse) getIntent().getSerializableExtra(WeatherIndexActivity.DATA);

        final DataRenderUtil renderUtil = new DataRenderUtil();

        header.setText(weatherResponse.city.name);
        Picasso.with(this)
                .load(renderUtil.getImageURL(weatherResponse.days.get(TODAY).descriptionList.get(0).imageID))
                .into(imageView);

        final Weather today = weatherResponse.days.get(TODAY);

        shortDescription.setText(today.descriptionList.get(0).shortDescription);
        longDescription.setText(today.descriptionList.get(0).longDescription);

        temperature.setText("temperature: " + renderUtil.DoubleToIntString(today.temperature.day) + "°C");
        humidity.setText("humidity: " + renderUtil.DoubleToIntString(today.humidity) + "%");
        wind.setText("wind: " + renderUtil.DoubleToIntString(today.windSpeed) + "m/s");
        clouds.setText("cloudness: " + renderUtil.DoubleToIntString(today.clouds) + "%");
        pressure.setText("pressure: " + renderUtil.DoubleToIntString(today.pressure) + "hPa");

        ArrayList<Weather> days = new ArrayList<>(weatherResponse.days);
        days.remove(TODAY);

        detailsArrayAdapter = new DetailsArrayAdapter(this, days);
        listview.setAdapter(detailsArrayAdapter);

    }
}
