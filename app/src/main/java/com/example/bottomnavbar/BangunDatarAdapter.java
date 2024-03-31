package com.example.bottomnavbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BangunDatarAdapter extends RecyclerView.Adapter<BangunDatarAdapter.MyViewHolder> {
    Context context;
    ArrayList<Model> modelBangunDatar;
    ItemClickListener mClickListener;

    public BangunDatarAdapter(Context context, ArrayList<Model> modelBangunDatar) {
        this.context = context;
        this.modelBangunDatar = modelBangunDatar;
    }

    @NonNull
    @Override
    public BangunDatarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout_bangun_datar, parent, false);
        return new BangunDatarAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BangunDatarAdapter.MyViewHolder holder, int position) {
        holder.tvBangunDatar.setText(modelBangunDatar.get(position).getNama());
        Glide.with(context)
                .load(modelBangunDatar.get(position).getImg())
                .into(holder.imgBangunDatar);
    }

    @Override
    public int getItemCount() {
        return modelBangunDatar.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgBangunDatar;
        TextView tvBangunDatar;

        public MyViewHolder(@NonNull View itemView){//MyViewHolder digunakan untuk mengetahui isi dari per index
            super(itemView);

            imgBangunDatar = itemView.findViewById(R.id.imgBangunDatar);
            tvBangunDatar = itemView.findViewById(R.id.tvBangunDatar);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
    Model getItem(int id){
        return modelBangunDatar.get(id);
    }

    public void setClickListener(BangunDatarAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
