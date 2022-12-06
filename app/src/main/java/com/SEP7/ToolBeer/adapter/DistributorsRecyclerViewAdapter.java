package com.SEP7.ToolBeer.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.SEP7.ToolBeer.R;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRDistributors;
import com.SEP7.ToolBeer.data.Repository.Repository;
import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class DistributorsRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final View view;
    private ArrayList<Distributors> forhandlereList = new ArrayList<>();
    private final IRDistributors repository;
    private final PropertyChangeSupport propertyChangeSupport; //boer maaske slettes

    public DistributorsRecyclerViewAdapter(View view) {
        repository = Repository.getInstance(null); //dette kan give problemer hvis det her er foeste gang den instancieres, dette skal lige foelges op paa
        repository.collectDistributors();
        this.view = view;

        propertyChangeSupport = new PropertyChangeSupport(this);
        repository.addPropertyChangeListener("eventDistributors", (PropertyChangeEvent evt) -> this.getDistriputors());
    }

    public void getDistriputors() {
        forhandlereList = repository.getDistributors();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_view, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n") //supressing a warning, may be a better way to do it
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.forhandlerNavn.setText(forhandlereList.get(position).getName() + ", "
                //forhandlereList.get(position).getAdresse() + ", "
                + forhandlereList.get(position).getOpeningHours() + ", " + forhandlereList.get(position).getWebsite());
    }

    @Override
    public int getItemCount() {
        return forhandlereList.size();
    }
}
