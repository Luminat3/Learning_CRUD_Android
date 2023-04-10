package com.luminate.simplereminder;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {
    private List<model> modelList;
    private Activity activity;
    DatabaseReference db = FirebaseDatabase.getInstance().getReference("event");

    public adapter(List<model>modelList, Activity activity)
    {
        this.modelList = modelList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final model data = modelList.get(position);
        holder.tv_title.setText("Title : " + data.getTitle());
        holder.tv_event.setText("Event : " + data.getEvent());
//        holder.tv_date.setText("Date : " + data.getDate());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_title, tv_event, tv_date;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_event = itemView.findViewById(R.id.tv_event);
            tv_date = itemView.findViewById(R.id.tv_tanggal);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
