package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;

public class EarthQuakeAdaptor extends ArrayAdapter<Earthquake> {

    public EarthQuakeAdaptor(Activity context, ArrayList<Earthquake> words) {

        super(context, 0, words);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquakelayout, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView cityTextView = (TextView) listItemView.findViewById(R.id.city_value);
        cityTextView.setText(currentEarthquake.getCity());

        TextView splitCityTextView = (TextView) listItemView.findViewById(R.id.split_city_value);
        splitCityTextView.setText(currentEarthquake.getSplitCity());

        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag_value);
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMag());
        magTextView.setText(formattedMagnitude);

        Date dateObject = new Date(currentEarthquake.getTime());
        TextView dateView = (TextView)listItemView.findViewById(R.id.date);

        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView)listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMag());

        magnitudeCircle.setColor(magnitudeColor);



        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

    private String formatMagnitude(double magnitude){
        DecimalFormat magnitudeFormat = new DecimalFormat(("0.0"));
        return  magnitudeFormat.format(magnitude);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
