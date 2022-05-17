package com.androidaflevering.smartpark.ui.mineparkeringer;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidaflevering.smartpark.R;

import java.util.List;


public class ParkingAdapter extends RecyclerView.Adapter<ParkingAdapter.ViewHolder> {
    List<Parking> parking;

    public ParkingAdapter(List<Parking> parking) {
        this.parking = parking;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.parking, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.name.setText(parking.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return parking.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }
    }
}
