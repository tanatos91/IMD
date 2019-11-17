package com.example.imd.View;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imd.R;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import adapter.Refuel;

import static android.widget.Toast.LENGTH_SHORT;


public class NewFuelFragment extends Fragment {
    private Refuel refuel;
    private OnFragmentInteractionListener mListener;
    private GregorianCalendar date;
    private TextView dateShow;
    private Context myContext;
    private Button cancelButton;
    private Button saveButton;
    private ImageButton chooseDateButton;
    private EditText mileageEditText;
    private EditText volumeEditText;
    private EditText priceEditText;
    private CheckBox fullCheckBox;
    private SimpleDateFormat dateFormat;

    private DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            date.set(GregorianCalendar.YEAR, year);
            date.set(GregorianCalendar.MONTH, monthOfYear);
            date.set(GregorianCalendar.DAY_OF_MONTH, dayOfMonth);

            if (dateShow != null) dateShow.setText(dateFormat.format(date.getTime()));
        }
    };


    public NewFuelFragment() {
        // Required empty public constructor
    }


    /*public static NewFuelFragment newInstance(String param1, String param2) {
        NewFuelFragment fragment = new NewFuelFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        if (getArguments() != null) {
            //  mParam1 = getArguments().getString(ARG_PARAM1);
            // mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewHierarchy = inflater.inflate(R.layout.fragment_new_fuel, null);
        dateShow = viewHierarchy.findViewById(R.id.newFuelDateShow);
        date = (GregorianCalendar) GregorianCalendar.getInstance();
        dateShow.setText(dateFormat.format(date.getTime()));

        cancelButton = viewHierarchy.findViewById(R.id.cancelFuelButton);
        cancelButton.setOnClickListener(v -> mListener.onFragmentInteraction(cancelButton));

        saveButton = viewHierarchy.findViewById(R.id.saveFuelButton);
        saveButton.setOnClickListener(v -> mListener.onFragmentInteraction(saveButton));

        chooseDateButton = viewHierarchy.findViewById(R.id.chooseDateButton);

        chooseDateButton.setOnClickListener(v -> showChooseDateDialog());

        mileageEditText = viewHierarchy.findViewById(R.id.newFuelMileageTextInput);
        volumeEditText = viewHierarchy.findViewById(R.id.newFuelVolumeTextInput);
        priceEditText = viewHierarchy.findViewById(R.id.newFuelPriceTextInput);
        fullCheckBox = viewHierarchy.findViewById(R.id.newFuelFullTankCheckBox);
        return viewHierarchy;
    }

    private void showChooseDateDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(myContext,
                onDateSetListener, date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.MONTH), date.get(GregorianCalendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public Refuel getRefuel() {

        return new Refuel(this.date,
                Integer.parseInt(this.mileageEditText.getText().toString()),
                Double.parseDouble(this.volumeEditText.getText().toString()),
                Double.parseDouble(this.priceEditText.getText().toString()),
                this.fullCheckBox.isChecked());
    }

    public boolean isRefuelCorrect(Refuel lastRefuel) {
        String milText = this.mileageEditText.getText().toString();
        String volText = this.volumeEditText.getText().toString();
        String priText = this.priceEditText.getText().toString();

        if (milText.isEmpty()) {
            Toast.makeText(myContext, getText(R.string.nFuFr_enterTheMileage), LENGTH_SHORT).show();
            return false;
        }

        if (Integer.parseInt(milText) <= lastRefuel.getRefuelMileage()) {
            Toast.makeText(myContext, getText(R.string.nFuFr_mileageMustBeMore), LENGTH_SHORT).show();
            return false;
        }
        ///////////////
        if (volText.isEmpty()) {
            Toast.makeText(myContext, getText(R.string.nFuFr_volumeMustBeMore), LENGTH_SHORT).show();
            return false;
        }

        if (Double.parseDouble(volText) <= 0.0) {
            Toast.makeText(myContext, getText(R.string.nFuFr_volumeMustBeMore), LENGTH_SHORT).show();
            return false;
        }
        ////////////////
        if (priText.isEmpty()) {
            Toast.makeText(myContext, getText(R.string.nFuFr_enterFuelPrice), LENGTH_SHORT).show();
            return false;
        }

        if (Double.parseDouble(priText) < 0.0) {
            Toast.makeText(myContext, getText(R.string.nFuFr_priceMostBePositive), LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    public boolean isRefuelCorrect() {
        String milText = this.mileageEditText.getText().toString();
        String volText = this.volumeEditText.getText().toString();
        String priText = this.priceEditText.getText().toString();

        if (milText.isEmpty()) {
            Toast.makeText(myContext, getText(R.string.nFuFr_enterTheMileage), LENGTH_SHORT).show();
            return false;
        }
        ///////////////
        if (volText.isEmpty()) {
            Toast.makeText(myContext, getText(R.string.nFuFr_volumeMustBeMore), LENGTH_SHORT).show();
            return false;
        }
        if (Double.parseDouble(volText) <= 0.0) {
            Toast.makeText(myContext, getText(R.string.nFuFr_volumeMustBeMore), LENGTH_SHORT).show();
            return false;
        }
        ////////////////
        if (priText.isEmpty()) {
            Toast.makeText(myContext, getText(R.string.nFuFr_enterFuelPrice), LENGTH_SHORT).show();
            return false;
        }

        if (Double.parseDouble(priText) < 0.0) {
            Toast.makeText(myContext, getText(R.string.nFuFr_priceMostBePositive), LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        this.myContext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setDefaultValues() {
        if (dateShow != null) dateShow.setText(dateFormat.format(date.getTime()));
        if (mileageEditText != null) mileageEditText.setText("");
        if (volumeEditText != null) volumeEditText.setText("");
        if (priceEditText != null) priceEditText.setText("");
        if (fullCheckBox != null) fullCheckBox.setChecked(true);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(View v);
    }

}
