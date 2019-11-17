package com.example.imd.View;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imd.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import adapter.Refuel;
import adapter.RefuelListSource;

import static android.widget.Toast.LENGTH_SHORT;

public class FuelLogFragment extends Fragment implements RefuelAdapter.ItemClickListener, RefuelListSource {
    private RefuelAdapter fuelLogRecyclerAdapter;
    private FloatingActionButton mNewFuelActionButton;
    private ArrayList<Refuel> refuelList;
    private RecyclerView fuelLogRecyclerView;
    private NewFuelFragment.OnFragmentInteractionListener mListener;
    private Context myContext;
    private RefuelListSource refuelListSource;

    public static FuelLogFragment getInstance(Object o) {
        FuelLogFragment fragment = new FuelLogFragment();

        return fragment;
    }

    private FuelLogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //  mParam1 = getArguments().getString(ARG_PARAM1);
            // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        refuelList = refuelListSource.getFuelLogArrayList();
        View viewHierarchy = inflater.inflate(R.layout.fragment_fuel_log, null);
        fuelLogRecyclerView = viewHierarchy.findViewById(R.id.fuelLogRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(myContext);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);
        fuelLogRecyclerView.setLayoutManager(linearLayoutManager);
        fuelLogRecyclerAdapter = new RefuelAdapter(myContext, refuelList);
        fuelLogRecyclerAdapter.setClickListener(this);
        fuelLogRecyclerView.setAdapter(fuelLogRecyclerAdapter);
        mNewFuelActionButton = viewHierarchy.findViewById(R.id.newFuelActionButton);
        mNewFuelActionButton.setOnClickListener(v -> mListener.onFragmentInteraction(mNewFuelActionButton));

        return viewHierarchy;
    }

    public void setFuelLog(ArrayList<Refuel> refuelList) {
        this.refuelList = refuelList;
    }

    public void updateFuelLog(ArrayList<Refuel> refuelArrayList) {
        setFuelLog(refuelArrayList);
        fuelLogRecyclerAdapter.setRefuelList(this.refuelList);
        fuelLogRecyclerAdapter.notifyDataSetChanged();
        fuelLogRecyclerView.smoothScrollToPosition(fuelLogRecyclerView.getAdapter().getItemCount() - 1);
    }


    public void onDeleteLastItemButtonClick(View v) {
        if (mNewFuelActionButton.getVisibility() == View.VISIBLE)
            mListener.onFragmentInteraction(v);
    }

    public void onItemClick(View view, int position) {
        if (mNewFuelActionButton.getVisibility() == View.VISIBLE) {
            Toast.makeText(myContext, "You clicked " + fuelLogRecyclerAdapter.getItem(position).getRefuelMileage() + " on row number " + position, LENGTH_SHORT).show();
            // DialogFragment onItemClickDialog = new OnItemClickDialog();
            //onItemClickDialog.show(getSupportFragmentManager(), "onItemDialog");
        }
    }

    public void setNewRefuelButtonVisible() {
        mNewFuelActionButton.setVisibility(View.VISIBLE);

    }

    public void setNewRefuelButtonGone() {
        mNewFuelActionButton.setVisibility(View.GONE);

    }


    public Refuel getLastRefuel() {
        return refuelList.get(refuelList.size() - 1);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NewFuelFragment.OnFragmentInteractionListener) {
            mListener = (NewFuelFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        this.myContext = context;

        if (context instanceof RefuelListSource) {
            refuelListSource = (RefuelListSource) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ORefuelListSource");
        }
        this.refuelListSource = (RefuelListSource) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        refuelListSource = null;
    }

    @Override
    public ArrayList<Refuel> getFuelLogArrayList() {
        return refuelList;
    }
}
