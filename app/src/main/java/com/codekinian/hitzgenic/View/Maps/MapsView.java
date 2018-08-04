package com.codekinian.hitzgenic.View.Maps;

import android.content.Intent;

import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceModel;
import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceResult;
import com.codekinian.hitzgenic.Model.PlaceResult;
import com.codekinian.hitzgenic.Model.Places;

import java.util.List;

interface MapsView {
    void initMarker(List<GPlaceResult> result);
    void getDataSuccess(GPlaceModel model);
    void getDataFail(String message);
    void moveToDirect(Intent intent);
    void showLoading();
    void hideLoading();
}
