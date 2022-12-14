package com.SEP7.ToolBeer.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.SEP7.ToolBeer.R;
import com.SEP7.ToolBeer.data.Repository.RInterfaces.IRProducts;
import com.SEP7.ToolBeer.data.Repository.Repository;
import com.SEP7.ToolBeer.localDatabase.Entity.Products;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {


    private ArrayList<Products> products = new ArrayList<>();
    private final IRProducts repository;

    public ProductsRecyclerViewAdapter() {
        repository = Repository.getInstance(null);
        repository.collectProducts();
        repository.addPropertyChangeListener("eventProducts",
                (PropertyChangeEvent evt) ->
                        this.getProducts()
        );
    }

    public void getProducts() {
        products = (ArrayList<Products>) repository.getProducts();
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
        holder.forhandlerNavn.setText(products.get(position).getProdName() + ", "
                + products.get(position).getAlcoholP() + ", "
                + products.get(position).getType() + ", "
                + products.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return (products == null) ? 0 : products.size();
    }
}