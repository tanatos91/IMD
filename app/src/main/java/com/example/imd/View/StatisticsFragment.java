package com.example.imd.View;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import adapter.Refuel;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import by.ewoks.powervehicle.R;


public class StatisticsFragment extends Fragment {
    private double avConsumption = 0;
    private double drivingCost = 0;
    private int oneRefuelMileage = 0;
    private int totalMileage = 0;
    private double totalMoney = 0;
    private double totalFuel = 0;

    private TextView avConsumptionTextView;
    private TextView drivingCostTextView;
    private TextView oneRefuelMileageTextView;
    private TextView totalMileageTextView;
    private DecimalFormat df = new DecimalFormat("#.##");
    private Context myContext;

    private StatisticsFragment() {
        // Required empty public constructor
    }

    public static StatisticsFragment getInstance(Object o) {
        return new StatisticsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //  mParam1 = getArguments().getString(ARG_PARAM1);
            // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewHierarchy = inflater.inflate(R.layout.fragment_statistics, null);
        avConsumptionTextView = viewHierarchy.findViewById(R.id.avConsumptionTextView);
        drivingCostTextView = viewHierarchy.findViewById(R.id.avDrivingCostTextView);
        oneRefuelMileageTextView = viewHierarchy.findViewById(R.id.avTankMileageTextView);
        totalMileageTextView = viewHierarchy.findViewById(R.id.totalMileageTextView);
        updateStat();
        return viewHierarchy;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setStatisticFrom(ArrayList<Refuel> refuelList) {
        totalMileage = 0;
        totalMoney = 0;
        totalFuel = 0;
        if (refuelList.size() > 0) {
            totalMileage = refuelList.get(refuelList.size() - 1).getRefuelMileage() - refuelList.get(0).getRefuelMileage();
        }
        refuelList.forEach(refuel -> {
            totalMoney += refuel.getRefuelVolume() * refuel.getRefuelFuelPrice();
            totalFuel += refuel.getRefuelVolume();
        });
        avConsumption = totalFuel / totalMileage * 100;
        drivingCost = totalMoney / totalMileage * 100;
        oneRefuelMileage = 0;
        if (refuelList.size() > 0) {
            oneRefuelMileage = totalMileage / refuelList.size() - 1;
        }


    }

    public void updateStat() {
        this.totalMileageTextView.setText(String.format("%s %s", totalMileage, myContext.getResources().getString(R.string.RefAdap_km)));
        this.drivingCostTextView.setText(df.format(drivingCost) + " " + myContext.getResources().getString(R.string.frStat_byn100km));
        this.avConsumptionTextView.setText(df.format(avConsumption) + " " + myContext.getResources().getString(R.string.RefAdap_L100km));
        this.oneRefuelMileageTextView.setText(df.format(oneRefuelMileage) + " " + myContext.getResources().getString(R.string.RefAdap_km));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.myContext = context;

    }


}
