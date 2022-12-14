package com.SEP7.ToolBeer.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.SEP7.ToolBeer.R;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRFavorits;
import com.SEP7.ToolBeer.data.Repository.Repository;
import com.SEP7.ToolBeer.localDatabase.Entity.Products;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class FavoritsRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Products> favorits = new ArrayList<>();
    private final IRFavorits repository;

    public FavoritsRecyclerViewAdapter() {
        repository = Repository.getInstance(null);
        repository.collectFavorits();
        repository.addPropertyChangeListener("eventFavorits",
                (PropertyChangeEvent evt) ->
                        this.getFavorits()
        );
    }

    public void getFavorits() {
        favorits = repository.getFavorits();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.forhandlerNavn.setText(favorits.get(position).getProdName() + ", "
                + favorits.get(position).getAlcoholP() + ", "
                + favorits.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return (favorits == null) ? 0 : favorits.size();
    }
}