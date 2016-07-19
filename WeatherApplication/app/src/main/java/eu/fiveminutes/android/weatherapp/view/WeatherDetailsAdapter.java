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

public class WeatherDetailsAdapter extends ArrayAdapter<Weather>{

    private static final int FIRST = 0;

    private final Context context;
    private final ArrayList<Weather> days;
    private final DataRenderUtil renderUtil;

    public WeatherDetailsAdapter(Context context, ArrayList<Weather> days) {
        super(context, R.layout.rowlayout, days);
        this.context = context;
        this.days = days;
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

        final Weather weather = days.get(position);

        viewHolder.fillView(weather, context, renderUtil);

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

        public void fillView(final Weather weather, final Context context, final DataRenderUtil renderUtil) {
            city.setText(weather.descriptionList.get(FIRST).shortDescription);
            tempMin.setText(renderUtil.getTemperatureString(weather.temperature.min));
            tempMax.setText(renderUtil.getTemperatureString(weather.temperature.max));
            Picasso.with(context)
                    .load(renderUtil.getImageURL(weather.descriptionList.get(FIRST).imageID))
                    .into(imageView);
        }
    }
}
