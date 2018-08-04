package com.codekinian.hitzgenic.View.Maps;

import android.app.Activity;
import android.content.Intent;

import com.codekinian.hitzgenic.Base.BasePresenter;
import com.codekinian.hitzgenic.Model.GoogleDetailModel.GDetailModel;
import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceModel;
import com.codekinian.hitzgenic.Model.Places;
import com.codekinian.hitzgenic.Network.NetworkCallback;

public class MapsPresenter extends BasePresenter<MapsView> {

    MapsPresenter(MapsView view) {
        super.attachView(view);
    }

    void loadData(String location, String key, String type, int radius) {
        view.showLoading();
        addSubscribe(apiStores.getAllPlace(location, key, type, true, radius, null), new NetworkCallback<GPlaceModel>() {
            @Override
            public void onSuccess(GPlaceModel model) {
                view.getDataSuccess(model);
            }

            @Override
            public void onFailure(String message) {
                view.getDataFail(message);
            }

            @Override
            public void onFinish() {
                view.hideLoading();
            }
        });
    }

    void getDirect(String id, Activity activity) {
        Intent intent = new Intent(activity, DirectMapsActivity.class);
        intent.putExtra("id", id);
        view.moveToDirect(intent);
    }
}
