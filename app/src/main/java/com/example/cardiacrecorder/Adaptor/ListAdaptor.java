package com.example.cardiacrecorder.Adaptor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardiacrecorder.Details;
import com.example.cardiacrecorder.Domain.ListDomain;
import com.example.cardiacrecorder.R;

import java.io.Serializable;
import java.util.ArrayList;

public class ListAdaptor extends RecyclerView.Adapter<ListAdaptor.ViewHolder> {
    ArrayList<ListDomain> listDomains;

    public ListAdaptor(ArrayList<ListDomain> listDomains) {
        this.listDomains = listDomains;
    }

    @NonNull
    @Override
    public ListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_list, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdaptor.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.s_pressure.setText(listDomains.get(position).getSystolic_pressure());
        holder.di_pressure.setText(listDomains.get(position).getDiastolic_pressure());
        holder.date.setText(listDomains.get(position).getDate());
        holder.time.setText(listDomains.get(position).getTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(holder.itemView.getContext(), Details.class);
                ListDomain listItem = listDomains.get(position);
                intent.putExtra("var",listItem.getN1());
                intent.putExtra("key",listItem.getKey());
                intent.putExtra("systolic_pressure", listItem.getSystolic_pressure());
                intent.putExtra("diastolic_pressure", listItem.getDiastolic_pressure());
                intent.putExtra("date", listItem.getDate());
                intent.putExtra("time", listItem.getTime());
                holder.itemView.getContext().startActivity(intent);
               // intent.putExtra("object", (Serializable) listDomains.get(position));
                //holder.itemView.getContext().startActivity(intent);
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(holder.itemView.getContext(), Details.class);
//                intent.putExtra("object",listDomains.get(position));
//
//                holder.itemView.getContext().startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return listDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView s_pressure, di_pressure, date, time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            s_pressure = itemView.findViewById(R.id.systolic);
            di_pressure = itemView.findViewById(R.id.diastolic);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }
}
