package com.codekinian.hitzgenic.View.Favorite;

import android.app.Activity;
import android.content.Intent;

import com.codekinian.hitzgenic.Base.BasePresenter;
import com.codekinian.hitzgenic.Model.FavoriteModel;
import com.codekinian.hitzgenic.View.DetailPlace.DetailActivity;

public class FavoritePresenter extends BasePresenter<FavoriteView> {

    FavoritePresenter(FavoriteView view) {
        super.attachView(view);
    }

    void getItem(String id, Activity activity) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra("id", id);
        view.moveToDetail(intent);
    }
}