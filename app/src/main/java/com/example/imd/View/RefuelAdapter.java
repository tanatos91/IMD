package com.example.imd.View;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import adapter.Refuel;
import adapter.StatRefuel;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import by.ewoks.powervehicle.R;

public class RefuelAdapter extends RecyclerView.Adapter<RefuelAdapter.ViewHolder> {
    private final Resources resources;
    private List<StatRefuel> refuelList;
    private LayoutInflater refuelInflater;
    private ItemClickListener refuelClickListener;
    private DecimalFormat df = new DecimalFormat("#.##");



    @RequiresApi(api = Build.VERSION_CODES.N)
    public RefuelAdapter(Context context, ArrayList<Refuel> refuelList) {
        this.refuelInflater = LayoutInflater.from(context);
        setRefuelList(refuelList);
        resources = context.getApplicationContext().getResources();

        // this.refuelList.sort(Comparator.comparing(Refuel2::getRefuel_mileage).reversed());
    }

    public void setRefuelList(ArrayList<Refuel> refuelList) {
        this.refuelList = StatRefuel.makeStatRefuelArrayListFrom(refuelList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.refuel_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        StatRefuel refuel = refuelList.get(position);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        holder.refuelDateTextView.setText(String.format("%s %s", resources.getString(R.string.RefAdap_date), dateFormat.format(refuel.getRefuelDate().getTime())));
        holder.refuelMileageTextView.setText(String.format("%s %d %s", resources.getString(R.string.RefAdap_mileage), refuel.getRefuelMileage(), resources.getString(R.string.RefAdap_km)));
        holder.refuelVolumeTextView.setText(String.format("%s %s %s", resources.getString(R.string.RefAdap_volume), refuel.getRefuelVolume(), resources.getString(R.string.RefAdap_L)));
        holder.refuelPriceTextView.setText(String.format("%s %s %s", resources.getString(R.string.RefAdap_fuelPrice), refuel.getRefuelFuelPrice(), resources.getString(R.string.RefAdap_bynL)));
        holder.refuelSummaryPriceTextView.setText(String.format("+ %s %s", df.format(refuel.getRefuelSumPrice()), resources.getString(R.string.RefAdap_byn)));
        if (refuel.isConsumptionEnable()) {
            holder.refuelConsumptionTextView.setText(String.format("%s %s", df.format(refuel.getConsumption()), resources.getString(R.string.RefAdap_L100km)));
            holder.refuelConsumptionTextView.setVisibility(View.VISIBLE);
        } else holder.refuelConsumptionTextView.setVisibility(View.INVISIBLE);

        if (refuel.isIncMileageEnable()) {
            holder.refuelIncMileageTextView.setText(String.format("+ %d %s", refuel.getIncMileage(), resources.getString(R.string.RefAdap_km)));
            holder.refuelIncMileageTextView.setVisibility(View.VISIBLE);
        } else holder.refuelIncMileageTextView.setVisibility(View.INVISIBLE);

        if (refuel.getFullTankFlag()) {
            holder.refuelIsTheTankFullTextView.setText(resources.getString(R.string.RefAdap_fullTank));
            holder.refuelIsTheTankFullTextView.setVisibility(View.VISIBLE);
        } else
            holder.refuelIsTheTankFullTextView.setVisibility(View.GONE);
        int listSize = refuelList.size();
        if (listSize - 1 == position) {
            holder.deletePositionButton.setVisibility(View.VISIBLE);
        }else {
            holder.deletePositionButton.setVisibility(View.GONE);
        }


    }

    public int getItemCount() {
        return refuelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView refuelVolumeTextView;
        TextView refuelDateTextView;
        TextView refuelMileageTextView;
        TextView refuelPriceTextView;
        TextView refuelIsTheTankFullTextView;

        TextView refuelIncMileageTextView;
        TextView refuelConsumptionTextView;
        TextView refuelSummaryPriceTextView;
        CardView cv;
        FloatingActionButton deletePositionButton;

        ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.refuelCardView);
            refuelVolumeTextView = itemView.findViewById(R.id.refuelVolumeTextView);
            refuelDateTextView = itemView.findViewById(R.id.refuelDateTextView);
            refuelMileageTextView = itemView.findViewById(R.id.refuelMileageTextView);
            refuelPriceTextView = itemView.findViewById(R.id.refuelPriceTextView);
            refuelIsTheTankFullTextView = itemView.findViewById(R.id.refuelFullTankTextView);
            deletePositionButton = itemView.findViewById(R.id.deletePositionButton);
            refuelIncMileageTextView = itemView.findViewById(R.id.refuelIncMileageTextView);
            refuelConsumptionTextView = itemView.findViewById(R.id.refuelConsumptionTextView);
            refuelSummaryPriceTextView = itemView.findViewById(R.id.refuelSummaryPriceTextView);

            itemView.setOnClickListener(this);
            deletePositionButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (refuelClickListener != null)
                if (view.getId() == R.id.deletePositionButton)
                    refuelClickListener.onDeleteLastItemButtonClick(deletePositionButton);
                else
                    refuelClickListener.onItemClick(view, getAdapterPosition());

        }
    }

    public Refuel getItem(int id) {
        return refuelList.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.refuelClickListener = itemClickListener;
    }


    public interface ItemClickListener {
        void onItemClick(View view, int position);

        void onDeleteLastItemButtonClick(View v);
    }
}
