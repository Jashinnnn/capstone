package com.example.capstone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class prodAdapter extends FirebaseRecyclerAdapter <prodModel,prodAdapter.myViewHolder>{
    public prodAdapter(@NonNull FirebaseRecyclerOptions<prodModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int i, @NonNull prodModel model) {
        holder.Name.setText(model.getName());
        holder.Description.setText(model.getDescription());
        holder.Price.setText(model.getPrice());
        holder.Stocks.setText(model.getStocks());


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_products,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder  extends RecyclerView.ViewHolder{
        TextView Name,Price,Description,Stocks;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            Name=itemView.findViewById(R.id.nametxt);
            Price=itemView.findViewById(R.id.pricetxt);
            Description =itemView.findViewById(R.id.descriptiontxt);
            Stocks =itemView.findViewById(R.id.stockstxt);


        }
    }
}
