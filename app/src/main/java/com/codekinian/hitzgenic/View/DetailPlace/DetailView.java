package com.codekinian.hitzgenic.View.DetailPlace;

import android.content.Intent;

import com.codekinian.hitzgenic.Model.GoogleDetailModel.GDetailModel;
import com.codekinian.hitzgenic.Model.GoogleDetailModel.GDetailResult;

interface DetailView {

    void showLoading();

    void hideLoading();

    void getDataSuccess(GDetailModel item);

    void getDataFail(String message);

    void refreshData();

    void moveToDirect(Intent intent);
}
