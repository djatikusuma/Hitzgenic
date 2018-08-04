package com.codekinian.hitzgenic.View.Main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.codekinian.hitzgenic.Adapter.CardFragmentPagerAdapter;
import com.codekinian.hitzgenic.Adapter.CardPagerAdapter;
import com.codekinian.hitzgenic.Adapter.PlacesAdapter;
import com.codekinian.hitzgenic.Base.MvpFragment;
import com.codekinian.hitzgenic.BuildConfig;
import com.codekinian.hitzgenic.Model.CardItem;
import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceModel;
import com.codekinian.hitzgenic.Model.GooglePlaceModel.GPlaceResult;
import com.codekinian.hitzgenic.Model.PlaceResult;
import com.codekinian.hitzgenic.Model.Places;
import com.codekinian.hitzgenic.R;
import com.codekinian.hitzgenic.Utils.GPSTracker;
import com.codekinian.hitzgenic.Utils.RecyclerItemClickListener;
import com.codekinian.hitzgenic.Utils.ShadowTransformer;
import com.codekinian.hitzgenic.Utils.TabLayout.CustomTabLayout;
import com.codekinian.hitzgenic.Utils.VerticalLineDecoration;
import com.google.android.gms.maps.model.LatLng;
import com.shashank.sony.fancytoastlib.FancyToast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.views.BannerSlider;

public class MainFragment extends MvpFragment<MainPresenter> implements MainView {
    private CardPagerAdapter mCardAdapter;
    public static String POSITION = "POSITION";
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private Unbinder unbinder;
    private Unbinder unbinderTwo;
    private FragmentActivity myContext;

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabs)
    CustomTabLayout tabLayout;


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.unbinder = ButterKnife.bind(this, view);

        View headerView = inflater.inflate(R.layout.category_card, container, false);

        CardView parkTab = (CardView) headerView.findViewById(R.id.park_tab);
        CardView museumTab = (CardView) headerView.findViewById(R.id.museum_tab);
        CardView kafeTab = (CardView) headerView.findViewById(R.id.kafe_tab);
        CardView restoTab = (CardView) headerView.findViewById(R.id.resto_tab);

        mFragmentCardAdapter = new CardFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(mFragmentCardAdapter);
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setCustomView(parkTab);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setCustomView(museumTab);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setCustomView(kafeTab);
        Objects.requireNonNull(tabLayout.getTabAt(3)).setCustomView(restoTab);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        if(savedInstanceState == null){
            viewPager.setCurrentItem(0);
        }


        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onDestroyView() {
        if (this.unbinder != null) {
            this.unbinder.unbind();
        }

        super.onDestroyView();
    }
}
