package com.SEP7.ToolBeer.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.SEP7.ToolBeer.R;


public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView samarbejdspartnerNavn;
    public View view;

    ViewHolder(View itemView) {
        super(itemView);
        samarbejdspartnerNavn = itemView.findViewById(R.id.samarbejdsPartnere);
        this.view = itemView;
    }
}

