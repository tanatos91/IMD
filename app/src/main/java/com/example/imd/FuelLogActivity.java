package com.example.imd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.imd.Fragments.NewFuelFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import adapter.Refuel;
import adapter.RefuelAdapter;

import static android.widget.Toast.LENGTH_SHORT;

public class FuelLogActivity extends AppCompatActivity implements RefuelAdapter.ItemClickListener {
    private RefuelAdapter fuelLogRecyclerAdapter;
    private FloatingActionButton mNewFuelActionButton;
    private ArrayList<Refuel> refuelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_log);

        initFuelLogRecyclerView();


        NewFuelFragment fuelFragment = new NewFuelFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.newFuelFragment, fuelFragment).commit();



        mNewFuelActionButton = findViewById(R.id.newFuelActionButton);
        mNewFuelActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(FuelLogActivity.this, ServiceLogActivity.class);
                //startActivity(intent);
                Toast.makeText(getApplicationContext(), "New fuel", LENGTH_SHORT).show();

            }
        });

    }

    private void initFuelLogRecyclerView() {
        refuelList = new ArrayList<>();
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 20000, 16, 1.65, Refuel.FULL_TANK));
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 20400, 16, 1.65, Refuel.FULL_TANK));
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 20800, 16, 1.65, Refuel.FULL_TANK));
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 21200, 16, 1.65, Refuel.FULL_TANK));
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 21600, 16, 1.65, Refuel.FULL_TANK));
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 22000, 16, 1.65, Refuel.NOT_FULL_TANK));
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 22400, 16, 1.65, Refuel.FULL_TANK));
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 22800, 16, 1.65, Refuel.FULL_TANK));
        refuelList.add(new Refuel(new GregorianCalendar(2016, Calendar.JUNE, 31), 23200, 16, 1.65, Refuel.FULL_TANK));

        RecyclerView fuelLogRecyclerView = findViewById(R.id.fuelLogRecyclerView);
        fuelLogRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fuelLogRecyclerAdapter = new RefuelAdapter(this, refuelList);
        fuelLogRecyclerAdapter.setClickListener(this);
        fuelLogRecyclerView.setAdapter(fuelLogRecyclerAdapter);
    }

    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + fuelLogRecyclerAdapter.getItem(position).getRefuelDateString() + " on row number " + position, LENGTH_SHORT).show();
    }


}
