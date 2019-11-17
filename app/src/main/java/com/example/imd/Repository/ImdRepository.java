package com.example.imd.Repository;

import android.content.Context;

import androidx.room.Room;

import com.example.imd.MainImd;

import java.util.ArrayList;

import adapter.Refuel;
import adapter.RefuelDao;
import adapter.RefuelDataBase;

public class ImdRepository implements MainImd.Repository {

    private static final String TAG = "ImdRepository";
    private RefuelDataBase refuelBase;
    private RefuelDao refuelDao;

    public ImdRepository(Context applicationContext){
        refuelBase = Room.databaseBuilder(applicationContext, RefuelDataBase.class, "refuels_database")
                .allowMainThreadQueries().build();
// allowMainThreadQueries - разрешает использовать базу данных из main потока.
// Так лучше не делать, но для тестовых целей подходит
        refuelDao = refuelBase.getRefuelDao();
    }

    @Override
    public ArrayList<Refuel> getFuelLogArrayList() {
        return (ArrayList<Refuel>) refuelBase.getRefuelDao().getAllRefuelList();
    }

    @Override
    public void addRefuelToFuelLog(Refuel refuel) {
        refuelDao.insert(refuel);
    }

    @Override
    public void removeRefuelFromFuelLog(Refuel refuel) {
        refuelDao.delete(refuel);


    }

    @Override
    public void editRefuelInFuelLog() {

    }


}
