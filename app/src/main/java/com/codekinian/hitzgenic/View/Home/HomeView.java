package com.codekinian.hitzgenic.View.Home;

import android.content.Intent;

import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceModel;

public interface HomeView {
        void showLoading();

        void hideLoading();

        void getDataSuccess(GPlaceModel model);

        void getDataFail(String message);

        void moveToDetail(Intent intent);

        void getMoreData(GPlaceModel model);
}