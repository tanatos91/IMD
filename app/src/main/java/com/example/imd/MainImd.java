package com.example.imd;

import android.content.Context;

import java.util.ArrayList;

import adapter.Refuel;

public interface MainImd {
    int FUEL_LOG = 1;
    int SERVICE_LOG = 2;
    int STATISTICS = 3;
    int SETTINGS = 4;

    interface View {

        void setFuelLog(ArrayList<Refuel> refuelArrayList);
        void updateFuelLog(ArrayList<Refuel> refuelArrayList);
        void showNewFuelDialog();
        void removeNewFuelDialog();
        void removeAllFragments();
        void goToFuelLog();
        void goToServiceLog();
        void goToStatistics(ArrayList<Refuel> refuelArrayList);
        void goToSettings();
        Context getApplicationContext();
        Refuel getRefuelFromNewFuelDialog();
        Refuel getLastRefuel();
    }

    interface Presenter {
        void goToFuelLog();
        void goToServiceLog();
        void goToStatistics();
        void goToSettings();
        void onEnterNewFuelButtonWasClicked();
        void onNewFuelSafeButtonWasClicked();
        void onNewFuelCancelButtonWasClicked();
        void onFuelLogItemWasClicked();
        void onDeleteLastRefuelButtonWasClicked();
        void onDestroy();
        void makeStartView();
        ArrayList<Refuel> getFuelLogArrayList();
    }

    interface Repository {
        ArrayList<Refuel> getFuelLogArrayList();
        void addRefuelToFuelLog(Refuel refuel);
        void removeRefuelFromFuelLog(Refuel refuel);
        void editRefuelInFuelLog();
    }
}
