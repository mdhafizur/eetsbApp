package com.example.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder>  {
    LayoutInflater inflater;
    private List<String> names;


    public StationsAdapter(Context context, List<String> names){ //Adapter constructor
        this.inflater = LayoutInflater.from(context);
        this.names = names;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.stations_custom,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = names.get(0);
        String address = names.get(1);
        String coordinates = names.get(2);
        String date = names.get(3);
        String battery = names.get(4);

        holder.name.setText(name);
        holder.address.setText(address);
        holder.coordinates.setText(coordinates);
        holder.date.setText(date);
        holder.battery.setText(battery);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, address, coordinates,battery,date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.sName);
            address = itemView.findViewById(R.id.sAddress);
            coordinates = itemView.findViewById(R.id.sCoordinates);
            date = itemView.findViewById(R.id.sDate);
            battery = itemView.findViewById(R.id.sBattery);
        }
    }

}
