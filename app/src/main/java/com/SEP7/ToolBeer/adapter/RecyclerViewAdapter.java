package com.SEP7.ToolBeer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.SEP7.ToolBeer.R;
import com.SEP7.ToolBeer.data.Repository.UserRepository;
import com.SEP7.ToolBeer.localDatabase.ForhandlereInfo;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final View view;
    private ArrayList<ForhandlereInfo> forhandlereList = new ArrayList<>();

    public RecyclerViewAdapter(View view) {
    forhandlereList = UserRepository.getInstance(null).getAList();
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
        holder.forhandlerNavn.setText(forhandlereList.get(position).getForhandlerNavn() + ", "
                //forhandlereList.get(position).getAdresse() + ", "
                 + forhandlereList.get(position).getAabningstider() + ", " + forhandlereList.get(position).getWebsite());
    }

    @Override
    public int getItemCount() {
        return forhandlereList.size();
    }
}
