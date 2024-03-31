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

public class BangunRuangAdapter extends RecyclerView.Adapter<BangunRuangAdapter.MyViewHolder> {
    Context context;
    ArrayList<Model> modelBangunRuang;
    ItemClickListener mClickListener;

    public BangunRuangAdapter(Context context, ArrayList<Model> modelBangunRuang) {
        this.context = context;
        this.modelBangunRuang = modelBangunRuang;
    }

    @NonNull
    @Override
    public BangunRuangAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout_bangun_ruang, parent, false);
        return new BangunRuangAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BangunRuangAdapter.MyViewHolder holder, int position) {
        holder.tvBangunRuang.setText(modelBangunRuang.get(position).getNama());
        Glide.with(context)
                .load(modelBangunRuang.get(position).getImg())
                .into(holder.imgBangunRuang);
    }

    @Override
    public int getItemCount() {
        return modelBangunRuang.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgBangunRuang;
        TextView tvBangunRuang;

        public MyViewHolder(@NonNull View itemView){//MyViewHolder digunakan untuk mengetahui isi dari per index
            super(itemView);

            imgBangunRuang = itemView.findViewById(R.id.imgBangunRuang);
            tvBangunRuang = itemView.findViewById(R.id.tvBangunRuang);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
    Model getItem(int id){
        return modelBangunRuang.get(id);
    }

    public void setClickListener(BangunRuangAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
