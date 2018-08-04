package com.codekinian.hitzgenic.Utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.codekinian.hitzgenic.BuildConfig;
import com.codekinian.hitzgenic.Model.ClusterModel;
import com.codekinian.hitzgenic.Model.PlaceModel;
import com.codekinian.hitzgenic.R;

import com.bumptech.glide.Glide;
import com.codekinian.hitzgenic.Model.PlaceResult;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.SphericalUtil;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class CustomInfoWindows implements GoogleMap.InfoWindowAdapter {

    private Activity context;
    private boolean first = false;
    private Resources resources;

    public CustomInfoWindows(Activity ctx){
        context = ctx;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getInfoContents(Marker marker) {
        View view = (context).getLayoutInflater()
                .inflate(R.layout.custom_infowindows, null);

        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.ic_error_white_24dp);
        requestOptions.error(R.drawable.ic_info_white_24dp);

        TextView title = view.findViewById(R.id.title);
        TextView distance = view.findViewById(R.id.distance);
//        ImageView cover = view.findViewById(R.id.cover);

        PlaceModel placeModel = (PlaceModel) marker.getTag();
        Double dis = SphericalUtil.computeDistanceBetween(placeModel.getFrom(), placeModel.getTo())/1000;
        DecimalFormat df = new DecimalFormat("0.#");

        title.setText(placeModel.getPlace());
        distance.setText(df.format(dis)+" Km");
        /*Picasso.with(context).load(placeModel.getImage())
                .into(cover, new MarkerCallback(marker));*/


        return view;
    }

    static class MarkerCallback implements Callback
    {
        Marker marker = null;

        MarkerCallback(Marker marker)
        {
            this.marker = marker;
        }

        @Override
        public void onError() {}

        @Override
        public void onSuccess()
        {
            if (marker == null)
            {
                return;
            }

            if (!marker.isInfoWindowShown())
            {
                return;
            }

            // If Info Window is showing, then refresh it's contents:

            marker.hideInfoWindow(); // Calling only showInfoWindow() throws an error
            marker.showInfoWindow();
        }
    }
}
