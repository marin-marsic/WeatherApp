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

public class DetailsArrayAdapter extends ArrayAdapter<Weather>{

    private final Context context;
    private final ArrayList<Weather> days;

    public DetailsArrayAdapter(Context context, ArrayList<Weather> days) {
        super(context, R.layout.rowlayout, days);
        this.context = context;
        this.days = days;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        final ViewHolder viewHolder = new ViewHolder(rowView);

        final DataRenderUtil renderUtil = new DataRenderUtil();

        final Weather weather = days.get(position);

        viewHolder.city.setText(weather.descriptionList.get(0).shortDescription);
        viewHolder.tempMin.setText(renderUtil.doubleToIntString(weather.temperature.min) + "°C");
        viewHolder.tempMax.setText(renderUtil.doubleToIntString(weather.temperature.max) + "°C");
        Picasso.with(context)
                .load(renderUtil.getImageURL(weather.descriptionList.get(0).imageID))
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
