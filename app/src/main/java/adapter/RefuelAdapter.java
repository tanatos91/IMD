package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imd.R;

import java.util.List;

public class RefuelAdapter extends RecyclerView.Adapter<RefuelAdapter.ViewHolder> {
    private List<Refuel> refuelList;
    private LayoutInflater refuelInflater;
    private ItemClickListener refuelClickListener;

    public RefuelAdapter(Context context, List<Refuel> refuelList){
        this.refuelInflater = LayoutInflater.from(context);
        this.refuelList = refuelList;
    }

   @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.refuel_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position){
        Refuel refuel = refuelList.get(position);
        holder.refuelDateTextView.setText("Date: " + refuel.getRefuelDateString());
        holder.refuelMileageTextView.setText("Mileage: " + refuel.getRefuelMileage() + " km");
        holder.refuelVolumeTextView.setText("Volume: " + refuel.getRefuelVolume() + " L");
        holder.refuelPriceTextView.setText("Fuel price: " + refuel.getRefuelFuelPrice() + " BYN/L");
        if(refuel.getFullTankFlag()){
            holder.refuelIsTheTankFullTextView.setText("Full tank");
            holder.refuelIsTheTankFullTextView.setVisibility(View.VISIBLE);}
        else
        holder.refuelIsTheTankFullTextView.setVisibility(View.GONE);


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
        CardView cv;

        ViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.refuelCardView);
            refuelVolumeTextView = itemView.findViewById(R.id.refuelVolumeTextView);
            refuelDateTextView = itemView.findViewById(R.id.refuelDateTextView);
            refuelMileageTextView = itemView.findViewById(R.id.refuelMileageTextView);
            refuelPriceTextView = itemView.findViewById(R.id.refuelPriceTextView);
            refuelIsTheTankFullTextView = itemView.findViewById(R.id.refuelFullTankTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (refuelClickListener != null) refuelClickListener.onItemClick(view, getAdapterPosition());
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
    }
}
