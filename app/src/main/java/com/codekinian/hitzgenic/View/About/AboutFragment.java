package com.codekinian.hitzgenic.View.About;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codekinian.hitzgenic.Base.MvpFragment;
import com.codekinian.hitzgenic.R;
import com.shashank.sony.fancyaboutpagelib.FancyAboutPage;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutFragment extends MvpFragment<AboutPresenter> implements AboutView {

    @Override
    protected AboutPresenter createPresenter() {
        return new AboutPresenter(this);
    }

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        FancyAboutPage fancyAboutPage= view.findViewById(R.id.fancyaboutpage);
        //fancyAboutPage.setCoverTintColor(Color.BLUE);  //Optional
        fancyAboutPage.setCover(R.drawable.park); //Pass your cover image
        fancyAboutPage.setName("Codekinian Developer");
        fancyAboutPage.setDescription("Kelompok RPL 11 pembangun Aplikasi Hitzgenic");
        fancyAboutPage.setAppIcon(R.drawable.brand_logo); //Pass your app icon image
        fancyAboutPage.setAppName("Hitzgenic");
        fancyAboutPage.setVersionNameAsAppSubTitle("Alpha");
        fancyAboutPage.setAppDescription("10115482 - Rangga Djatikusuma Lukman\n" +
                                         "10115481 - Angga Muhamad Ginanjar\n" +
                                         "10115456 - Siti Nurjanah\n" +
                                         "10115477 - Winda Pratiwi Septianti\n" +
                                         "10115460 - Muhammad Faishal");
        fancyAboutPage.addEmailLink("@email.unikom.ac.id");     //Add your email id
        fancyAboutPage.addFacebookLink("https://www.facebook.com/xntax");  //Add your facebook address url
        fancyAboutPage.addTwitterLink("https://twitter.com/xntax");
        fancyAboutPage.addLinkedinLink("https://www.linkedin.com/in/djatikusuma");
        fancyAboutPage.addGitHubLink("https://github.com/djatikusuma");

        return view;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
