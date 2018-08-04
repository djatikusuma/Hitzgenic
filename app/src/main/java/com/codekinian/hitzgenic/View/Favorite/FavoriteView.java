package com.codekinian.hitzgenic.View.Favorite;

import android.content.Intent;

import com.codekinian.hitzgenic.Model.FavoriteModel;
import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceModel;

public interface FavoriteView {
        void showLoading();

        void hideLoading();

        void moveToDetail(Intent intent);
}
