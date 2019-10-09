package com.example.imd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ServiceLogActivity extends AppCompatActivity {

    private RecyclerView serviceLogRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_log);

        initServiceLogRecyclerView();
    }
    private void initServiceLogRecyclerView() {
        serviceLogRecyclerView = findViewById(R.id.serviceLogRecyclerView);
    }

}
