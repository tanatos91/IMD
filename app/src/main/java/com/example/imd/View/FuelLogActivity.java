package com.example.imd.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.example.imd.MainImd;
import com.example.imd.R;

import com.example.imd.Presenter.ImdPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import adapter.Refuel;
import adapter.RefuelListSource;


public class FuelLogActivity extends AppCompatActivity implements NewFuelFragment.OnFragmentInteractionListener, MainImd.View, RefuelListSource {

    private static final String TAG = "ImdView";
    private NewFuelFragment newFuelFragment;
    private FuelLogFragment fuelLogFragment;
    private StatisticsFragment statisticsFragment;
    private TextView headerText;
    BottomNavigationView bottomNavigationView;
    private int state = 0;

    private ImdPresenter mPresenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bb_menu_fuelLog:
                    mPresenter.goToFuelLog();
                    return true;
                case R.id.bb_menu_serviceLog:
                    mPresenter.goToServiceLog();
                    return true;
                case R.id.bb_menu_statistics:
                    mPresenter.goToStatistics();
                    return true;
                case R.id.bb_menu_settings:
                    mPresenter.goToSettings();
                    return true;
            }
            return false;
        }


    };


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_log);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        headerText = findViewById(R.id.activityHeaderTextView);
        headerText.setText("");
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        newFuelFragment = new NewFuelFragment();
        fuelLogFragment = FuelLogFragment.getInstance(fuelLogFragment);
        statisticsFragment = StatisticsFragment.getInstance(statisticsFragment);
        this.mPresenter = new ImdPresenter(this);
        mPresenter.makeStartView();
    }


    @Override
    public void onFragmentInteraction(View v) {

        switch (v.getId()) {
            case R.id.newFuelActionButton:
                mPresenter.onEnterNewFuelButtonWasClicked();
                break;
            case R.id.cancelFuelButton:
                mPresenter.onNewFuelCancelButtonWasClicked();
                break;

            case R.id.deletePositionButton:
                mPresenter.onDeleteLastRefuelButtonWasClicked();
                break;

            case R.id.saveFuelButton:
                if (fuelLogFragment.getFuelLogArrayList().isEmpty()) {
                    if (!newFuelFragment.isRefuelCorrect()) break;
                } else if (!newFuelFragment.isRefuelCorrect(fuelLogFragment.getLastRefuel()))
                    break;
                mPresenter.onNewFuelSafeButtonWasClicked();
                break;
            case R.id.newFuelDateShow:
                //if (v instanceof TextView)
                //  ((TextView) v).setText();
                break;
            default:
                break;
        }


    }


    @Override
    public void setFuelLog(ArrayList<Refuel> refuelArrayList) {
        fuelLogFragment.updateFuelLog(refuelArrayList);
    }

    @Override
    public void updateFuelLog(ArrayList<Refuel> refuelArrayList) {
        fuelLogFragment.updateFuelLog(refuelArrayList);
    }

    @Override
    public void showNewFuelDialog() {
        fuelLogFragment.setNewRefuelButtonGone();
        bottomNavigationView.setVisibility(View.GONE);
        FragmentTransaction nfTrans;
        nfTrans = getSupportFragmentManager().beginTransaction();
        nfTrans.add(R.id.insertNewElementFrameLayout, this.newFuelFragment);
        //nfTrans.addToBackStack("newFuelTransaction");
        nfTrans.commit();
        newFuelFragment.setDefaultValues();
    }


    @Override
    public void removeNewFuelDialog() {
        // InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        hideKeyboard(this);
        newFuelFragment.setDefaultValues();
        FragmentTransaction fTrans;
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.remove(this.newFuelFragment);
        fTrans.commit();
        fuelLogFragment.setNewRefuelButtonVisible();
        bottomNavigationView.setVisibility(View.VISIBLE);


    }

    @Override
    public void removeAllFragments() {
        // InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        FragmentTransaction fTrans;
        fTrans = getSupportFragmentManager().beginTransaction();
        fTrans.remove(this.newFuelFragment);
        fTrans.remove(this.fuelLogFragment);
        fTrans.remove(this.statisticsFragment);
        fTrans.commit();

    }

    @Override
    public void goToFuelLog() {
        if (this.getState() != MainImd.FUEL_LOG) {
            //headerText.setText(R.string.fuel_log);
            //removeAllFragments();
            FragmentTransaction nfTrans;
            nfTrans = getSupportFragmentManager().beginTransaction();
            nfTrans.remove(this.newFuelFragment);
            nfTrans.replace(R.id.logListFrameLayout, this.fuelLogFragment);
            //nfTrans.addToBackStack("newFuelTransaction");
            nfTrans.commit();
            headerText.setText(R.string.fuel_log);
            setState(MainImd.FUEL_LOG);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void goToStatistics(ArrayList<Refuel> refuelArrayList) {
        if (getState() != MainImd.STATISTICS) {
            // removeAllFragments();
            statisticsFragment.setStatisticFrom(refuelArrayList);
            FragmentTransaction nfTrans;
            nfTrans = getSupportFragmentManager().beginTransaction();
            nfTrans.remove(this.newFuelFragment);
            nfTrans.replace(R.id.logListFrameLayout, this.statisticsFragment);
            //nfTrans.addToBackStack("newFuelTransaction");
            nfTrans.commit();
            headerText.setText(R.string.statistics);
            setState(MainImd.STATISTICS);
        }

    }

    @Override
    public void goToServiceLog() {
        if (getState() != MainImd.SERVICE_LOG) {
            removeAllFragments();
            headerText.setText(R.string.serviceLog);
            setState(MainImd.SERVICE_LOG);
        }

    }


    @Override
    public void goToSettings() {
        if (getState() != MainImd.SETTINGS) {
            removeAllFragments();
            setState(MainImd.SETTINGS);
        }
    }

    @Override
    public Refuel getRefuelFromNewFuelDialog() {
        return newFuelFragment.getRefuel();
    }

    @Override
    public Refuel getLastRefuel() {
        return fuelLogFragment.getLastRefuel();
    }


    @Override
    public ArrayList<Refuel> getFuelLogArrayList() {
        return mPresenter.getFuelLogArrayList();
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
