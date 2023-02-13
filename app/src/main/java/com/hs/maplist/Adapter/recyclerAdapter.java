package com.hs.maplist.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hs.maplist.R;
import com.hs.maplist.Model.*;

import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.OnSwipe;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.myviewholder>{

    Datum[] data;
    Context context;


    public recyclerAdapter(Datum[] data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_row,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        Datum datum =data[position];
        holder.name.setText(datum.getName());
        holder.uname.setText(datum.getUsername());
        holder.email.setText(datum.getEmail());
        holder.street.setText(datum.getAddress().getStreet());
        holder.city.setText(datum.getAddress().getCity());
        holder.zipcode.setText(datum.getAddress().getZipcode());
        //String lat=datum.getAddress().getGeo().getLat();
        //String lon=datum.getAddress().getGeo().getLng();
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView uname,email,street,city,zipcode,name;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            uname = itemView.findViewById(R.id.username);
            email = itemView.findViewById(R.id.email);
            street = itemView.findViewById(R.id.street_text);
            city = itemView.findViewById(R.id.city_text);
            zipcode = itemView.findViewById(R.id.zipcode_text);
        }
    }
}
