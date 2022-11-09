package com.SEP7.ToolBeer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.SEP7.ToolBeer.R;
import com.SEP7.ToolBeer.data.UserRepository;
import com.SEP7.ToolBeer.primitivDatabase.SamarbejdspartnereInfo;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private View view;
    private ArrayList<SamarbejdspartnereInfo> samarbejdsPartnereList = new ArrayList<>();

    public RecyclerViewAdapter(View view) {
    samarbejdsPartnereList = UserRepository.getInstance(null).getAList();
    this.view = view;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.samarbejdspartnerNavn.setText(samarbejdsPartnereList.get(position).getSamarbejdspartnerNavn() + ", "
                + samarbejdsPartnereList.get(position).getAdresse()
                + ", " + samarbejdsPartnereList.get(position).getAabningstider() + ", " + samarbejdsPartnereList.get(position).getTimePris() + " kr.");
    }

    @Override
    public int getItemCount() {
        return samarbejdsPartnereList.size();
    }
}
