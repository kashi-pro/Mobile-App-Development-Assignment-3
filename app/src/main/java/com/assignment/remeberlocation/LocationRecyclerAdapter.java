package com.assignment.remeberlocation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class LocationRecyclerAdapter extends RecyclerView.Adapter<LocationRecyclerAdapter.LocationViewHolder> {

    ArrayList<LocationModel> locationLists;
    Context context;

    public LocationRecyclerAdapter(Context ctxt, ArrayList<LocationModel> list) {
        context= ctxt;
        locationLists= list;
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflatedView= LayoutInflater.from(context).inflate(R.layout.locaton_card_template, parent, false);
        LocationViewHolder locationHolder= new LocationViewHolder(inflatedView);
        return locationHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {

        String name= locationLists.get(position).getName();
        String desc= locationLists.get(position).getDesc();

        holder.nameField.setText(name);
        holder.descField.setText(desc);

    }

    @Override
    public int getItemCount() {
        return locationLists.size();
    }

    class LocationViewHolder extends RecyclerView.ViewHolder {

        TextView nameField;
        TextView descField;

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            nameField= itemView.findViewById(R.id.locationName);
            descField= itemView.findViewById(R.id.locationDetail);
        }
    }

}
