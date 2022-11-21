package com.SEP7.ToolBeer.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.SEP7.ToolBeer.R;


public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView forhandlerNavn;
    public View view;

    ViewHolder(View itemView) {
        super(itemView);
        forhandlerNavn = itemView.findViewById(R.id.forhandlere);
        this.view = itemView;
    }
}

