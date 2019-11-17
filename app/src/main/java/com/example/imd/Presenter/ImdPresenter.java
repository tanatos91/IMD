package com.example.imd.Presenter;

import com.example.imd.MainImd;
import com.example.imd.Repository.ImdRepository;

import java.util.ArrayList;

import adapter.Refuel;
import adapter.RefuelListSource;

public class ImdPresenter implements MainImd.Presenter, RefuelListSource {

    private static final String TAG = "ImdPresenter";
    private MainImd.View mView;
    private MainImd.Repository mRepository;

    public ImdPresenter(MainImd.View mView) {
        this.mView = mView;
        this.mRepository = new ImdRepository(mView.getApplicationContext());


    }

    @Override
    public void goToFuelLog() {
        mView.goToFuelLog();
    }

    @Override
    public void goToServiceLog() {
        mView.goToServiceLog();
    }

    @Override
    public void goToStatistics() {
        mView.goToStatistics(mRepository.getFuelLogArrayList());
    }

    @Override
    public void goToSettings() {
        mView.goToSettings();
    }

    @Override
    public void onEnterNewFuelButtonWasClicked() {
        mView.showNewFuelDialog();
    }

    @Override
    public void onNewFuelSafeButtonWasClicked() {
        mRepository.addRefuelToFuelLog(mView.getRefuelFromNewFuelDialog());
        mView.updateFuelLog(mRepository.getFuelLogArrayList());
        mView.removeNewFuelDialog();

    }

    @Override
    public void onNewFuelCancelButtonWasClicked() {
        mView.removeNewFuelDialog();
    }

    @Override
    public void onFuelLogItemWasClicked() {

    }

    @Override
    public void onDeleteLastRefuelButtonWasClicked() {
        mRepository.removeRefuelFromFuelLog(mView.getLastRefuel());
        mView.updateFuelLog(mRepository.getFuelLogArrayList());


    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void makeStartView() {
        mView.goToFuelLog();

    }

    @Override
    public ArrayList<Refuel> getFuelLogArrayList() {
        return mRepository.getFuelLogArrayList();
    }
}
