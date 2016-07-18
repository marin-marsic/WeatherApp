package eu.fiveminutes.android.weatherapp.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.fiveminutes.android.weatherapp.R;
import eu.fiveminutes.android.weatherapp.config.Config;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import eu.fiveminutes.android.weatherapp.presenter.WeatherIndexPresenter;
import eu.fiveminutes.android.weatherapp.presenter.WeatherIndexPresenterImpl;

public final class WeatherIndexActivity extends Activity implements WeatherIndexView{

    private WeatherArrayAdapter weatherArrayAdapter;
    private WeatherIndexPresenter weatherIndexPresenter;

    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.error)
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_index);
        ButterKnife.bind(this);

        weatherArrayAdapter = new WeatherArrayAdapter(this, new ArrayList<WeatherResponse>(Config.CITIES.length));
        listview.setAdapter(weatherArrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final WeatherResponse weatherResponse = (WeatherResponse) adapterView.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),
                        weatherResponse.city.name + " clicked!", Toast.LENGTH_LONG)
                        .show();
            }
        });


        weatherIndexPresenter = new WeatherIndexPresenterImpl(this);
        weatherIndexPresenter.getData();
    }

    @Override
    public void renderCities(final ArrayList<WeatherResponse> responses) {
        weatherArrayAdapter.addAll(responses);
    }

    @Override
    public void clearAllCities() {
        weatherArrayAdapter.clear();
    }

    @Override
    public void showErrorMessage() {
        textView.setText(Config.ERROR_MESSAGE);
    }
}
