package com.codekinian.hitzgenic.View.Main;

import android.app.Activity;
import android.content.Intent;

import com.codekinian.hitzgenic.Base.BasePresenter;
import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceModel;
import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceResult;
import com.codekinian.hitzgenic.Model.PlaceResult;
import com.codekinian.hitzgenic.Model.Places;
import com.codekinian.hitzgenic.Network.NetworkCallback;
import com.codekinian.hitzgenic.View.DetailPlace.DetailActivity;

class MainPresenter extends BasePresenter<MainView> {

    MainPresenter(MainView view) {
        super.attachView(view);
    }
}