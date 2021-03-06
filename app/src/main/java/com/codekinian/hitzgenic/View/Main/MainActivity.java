package com.codekinian.hitzgenic.View.Main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import com.codekinian.hitzgenic.Adapter.CardFragmentPagerAdapter;
import com.codekinian.hitzgenic.Adapter.CardPagerAdapter;
import com.codekinian.hitzgenic.Base.BaseActivity;
import com.codekinian.hitzgenic.Model.CardItem;
import com.codekinian.hitzgenic.R;
import com.codekinian.hitzgenic.Utils.BottomNavigationBehavior;
import com.codekinian.hitzgenic.Utils.BottomNavigationViewHelper;
import com.codekinian.hitzgenic.Utils.ShadowTransformer;
import com.codekinian.hitzgenic.View.About.AboutFragment;
import com.codekinian.hitzgenic.View.Favorite.FavoriteFragment;
import com.codekinian.hitzgenic.View.Maps.MapsFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.shashank.sony.fancytoastlib.FancyToast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    ActionBar toolbar;
    private Context mContext = MainActivity.this;
    private static final int ACTIVITY_NUM = 0;
    private Fragment fragment = null;
    private Class fragmentClass = MainFragment.class;


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = getSupportActionBar();
        toolbar.setTitle("Hitzgenic");
        toolbar.setElevation(3);

        if(savedInstanceState == null){
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
        }

        setupBottomNavigationView();
    }

    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.navigation);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewEx.setItemHeight(BottomNavigationViewEx.dp2px(this, 36 + 16));

        enableNavigation(mContext, bottomNavigationViewEx);
        /*CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationViewEx.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());*/
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

    public void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.navigation_home :
                        fragmentClass = MainFragment.class;
                        break;
                    case R.id.navigation_maps :
                        fragmentClass = MapsFragment.class;
                        break;
                    case R.id.navigation_fav :
                        fragmentClass = FavoriteFragment.class;
                        break;
                    case R.id.navigation_about :
                        fragmentClass = AboutFragment.class;
                        break;
                    default :
                        fragmentClass = MainFragment.class;
                        break;
                }

                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                loadFragment(fragment);
                toolbar.setTitle(item.getTitle());
                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.frame_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}
