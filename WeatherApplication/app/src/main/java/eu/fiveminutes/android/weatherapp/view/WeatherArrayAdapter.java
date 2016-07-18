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
import eu.fiveminutes.android.weatherapp.model.WeatherResponse;

public final class  WeatherArrayAdapter extends ArrayAdapter<WeatherResponse>{
    private final Context context;
    private final ArrayList<WeatherResponse> responses;

    public WeatherArrayAdapter(Context context, ArrayList<WeatherResponse> responses) {
        super(context, R.layout.rowlayout, responses);
        this.context = context;
        this.responses = responses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        final ViewHolder viewHolder = new ViewHolder(rowView);

        final DataRenderUtil renderUtil = new DataRenderUtil();

        final WeatherResponse weatherResponse = responses.get(position);

        viewHolder.city.setText(weatherResponse.city.name);
        viewHolder.tempMin.setText(renderUtil.doubleToIntString(weatherResponse.days.get(0).temperature.min) + "°C");
        viewHolder.tempMax.setText(renderUtil.doubleToIntString(weatherResponse.days.get(0).temperature.max) + "°C");
        Picasso.with(context)
                .load(renderUtil.getImageURL(weatherResponse.days.get(0).descriptionList.get(0).imageID))
                .into(viewHolder.imageView);

        return rowView;
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
    }
}
