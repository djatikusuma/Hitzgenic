package com.codekinian.hitzgenic.View.Maps;

import com.codekinian.hitzgenic.Model.GoogleDetailModel.GDetailModel;
import com.codekinian.hitzgenic.Model.PlaceResult;
import com.codekinian.hitzgenic.Model.Places;

interface DirectMapsView {
    void getDataSuccess(GDetailModel model);
    void getDataFail(String message);
    void showLoading();
    void hideLoading();
}
