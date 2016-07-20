package eu.fiveminutes.android.weatherapp.view;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.fiveminutes.android.weatherapp.R;
import eu.fiveminutes.android.weatherapp.model.Weather;
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public final class WeatherArrayAdapter extends ArrayAdapter<WeatherResponse>{
    private static final int FIRST = 0;
    private static final int TODAY = 0;
    private final DataRenderUtil renderUtil;

    private final Context context;
    private final ArrayList<WeatherResponse> responses;

    public WeatherArrayAdapter(Context context, ArrayList<WeatherResponse> responses) {
        super(context, R.layout.rowlayout, responses);
        this.context = context;
        this.responses = responses;
        this.renderUtil = new DataRenderUtil();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            final LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.rowlayout, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final WeatherResponse weatherResponse = responses.get(position);

        viewHolder.fillView(weatherResponse, context, renderUtil);

        return convertView;
    }

    static final class ViewHolder {

        @BindView(R.id.title)
        TextView city;

        @BindView(R.id.tempMin)
        TextView tempMin;

        @BindView(R.id.tempMax)
        TextView tempMax;

        @BindView(R.id.icon)
        ImageView imageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }

        public void fillView(final WeatherResponse weatherResponse, final Context context, final DataRenderUtil renderUtil) {
            city.setText(weatherResponse.city.name);
            tempMin.setText(renderUtil.getTemperatureString(weatherResponse.days.get(FIRST).temperature.min));
            tempMax.setText(renderUtil.getTemperatureString(weatherResponse.days.get(FIRST).temperature.max));
            Picasso.with(context)
                    .load(renderUtil.getImageURL(weatherResponse.days.get(TODAY).descriptionList.get(FIRST).imageID))
                    .into(imageView);
        }
    }
}
