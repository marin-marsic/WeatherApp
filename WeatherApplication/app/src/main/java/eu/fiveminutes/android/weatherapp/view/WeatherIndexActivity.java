package eu.fiveminutes.android.weatherapp.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import eu.fiveminutes.android.weatherapp.R;
import eu.fiveminutes.android.weatherapp.config.Config;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;
import eu.fiveminutes.android.weatherapp.presenter.CitySearchPresenter;
import eu.fiveminutes.android.weatherapp.presenter.CitySearchPresenterImpl;
import eu.fiveminutes.android.weatherapp.presenter.WeatherIndexPresenter;
import eu.fiveminutes.android.weatherapp.presenter.WeatherIndexPresenterImpl;

public final class WeatherIndexActivity extends Activity implements WeatherIndexView{

    private static final String EMPTY = "";

    private WeatherArrayAdapter weatherArrayAdapter;
    private WeatherIndexPresenter weatherIndexPresenter;
    private CitySearchPresenter citySearchPresenter;

    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.error)
    TextView error;

    @BindView(R.id.search_button)
    ImageView searchIcon;

    @BindView(R.id.city_query)
    EditText cityInput;

    @BindView(R.id.index_swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_index);
        ButterKnife.bind(this);

        weatherArrayAdapter = new WeatherArrayAdapter(this, new ArrayList<>(Config.CITIES.length));
        listview.setAdapter(weatherArrayAdapter);

        addInputListener();
        addRefreshListener();

        weatherIndexPresenter = new WeatherIndexPresenterImpl(this);
        weatherIndexPresenter.getData();

        citySearchPresenter = new CitySearchPresenterImpl(this);
    }

    @Override
    public void renderCities(final ArrayList<WeatherResponse> responses) {
        weatherArrayAdapter.addAll(responses);
        error.setText(EMPTY);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void clearAllCities() {
        weatherArrayAdapter.clear();
    }

    @Override
    public void showErrorMessage() {
        swipeRefreshLayout.setRefreshing(false);
        error.setText(R.string.network_error);
    }

    @OnItemClick(R.id.listview)
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final WeatherResponse weatherResponse = (WeatherResponse) adapterView.getItemAtPosition(i);

        final Intent intent = WeatherDetailsActivity.createIntent(this, weatherResponse);
        startActivity(intent);
    }

    @OnClick(R.id.search_button)
    public void onClick(View view) {
        search();
    }

    @Override
    public void showSearchResult(final WeatherResponse weatherResponse) {
        final Intent intent = SearchResultActivity.createIntent(this, weatherResponse);
        startActivity(intent);
    }

    private void search() {
        final String city = cityInput.getText().toString();
        citySearchPresenter.getDataForCity(city);
    }

    private void addRefreshListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
                //final WeatherIndexPresenter weatherIndexPresenter = new WeatherIndexPresenterImpl(WeatherIndexActivity.this);
                weatherIndexPresenter.getData();
        });
    }

    private void addInputListener() {
        cityInput.setOnEditorActionListener((textView, actionId, keyEvent) -> {
                if ((keyEvent != null && (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    search();
                }
                return false;
        });
    }
}
