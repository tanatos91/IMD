package com.example.imd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private CardView mFuelLogCard;
    private CardView mServiceLogCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mFuelLogCard = findViewById(R.id.fuelLogButtonCardView);
        mFuelLogCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FuelLogActivity.class);
                startActivity(intent);

            }
        });

        mServiceLogCard = findViewById(R.id.serviceLogButtonCardView);
        mServiceLogCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiceLogActivity.class);
                startActivity(intent);

            }
        });
    }
}
