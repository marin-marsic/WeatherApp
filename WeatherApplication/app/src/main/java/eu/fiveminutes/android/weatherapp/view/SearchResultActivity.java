package eu.fiveminutes.android.weatherapp.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import eu.fiveminutes.android.weatherapp.R;
import eu.fiveminutes.android.weatherapp.model.Weather;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public final class SearchResultActivity extends Activity {

    private static final String DATA = "data";
    private static final String OK_CODE = "200";

    private WeatherArrayAdapter weatherArrayAdapter;

    @BindView(R.id.header)
    TextView header;

    @BindView(R.id.listview)
    ListView listview;

    @BindView(R.id.error)
    TextView errorView;

    public static Intent createIntent(final Context context, final WeatherResponse weatherResponse) {
        Intent intent = new Intent(context, SearchResultActivity.class);
        intent.putExtra(DATA, weatherResponse);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        ButterKnife.bind(this);

        final WeatherResponse weatherResponse = getIntent().getExtras().getParcelable(DATA);
        showContent(weatherResponse);
    }

    @OnItemClick(R.id.listview)
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final WeatherResponse weatherResponse = (WeatherResponse) adapterView.getItemAtPosition(i);

        final Intent intent = WeatherDetailsActivity.createIntent(this, weatherResponse);
        startActivity(intent);
    }

    private void showContent(final WeatherResponse weatherResponse) {
        if (!weatherResponse.code.equals(OK_CODE)) {
            showError(weatherResponse);
        } else {
            showResult(weatherResponse);
        }
    }

    private void showError(final WeatherResponse weatherResponse) {
        errorView.setText(weatherResponse.message);
    }

    private void showResult(final WeatherResponse weatherResponse) {
        final ArrayList<WeatherResponse> responses = new ArrayList<>();
        responses.add(weatherResponse);

        weatherArrayAdapter = new WeatherArrayAdapter(this, responses);
        listview.setAdapter(weatherArrayAdapter);
    }
}
