package com.example.pruebarecyclermodificable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    List<President> presidentList;
    Context context;

    public RecyclerViewAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

//    public RecyclerViewAdapter(List<President> presidentList) {
//
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_president,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_presName.setText(presidentList.get(position).getName());
        holder.tv_dateElection.setText(String.valueOf(presidentList.get(position).getDate()));
        Glide.with(this.context).load(presidentList.get(position).getImg()).into(holder.iv_presidentPicture);
    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_presidentPicture;
        TextView tv_presName;
        TextView tv_dateElection;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_presidentPicture=itemView.findViewById(R.id.iv_presidentPicture);
            tv_presName=itemView.findViewById(R.id.tv_presName);
            tv_dateElection=itemView.findViewById(R.id.tv_dateElection);
        }
    }
}
