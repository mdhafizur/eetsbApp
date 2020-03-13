package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder>  {
    LayoutInflater inflater;
    String nameS;


    public StationsAdapter(Context context, String nameS){ //Adapter constructor
        this.inflater = LayoutInflater.from(context);
        this.nameS = nameS;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.stations_custom,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.nameS.setText(nameS);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameS;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameS = itemView.findViewById(R.id.sName);
        }
    }

}
