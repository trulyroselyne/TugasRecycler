package com.example.tugasrecycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VacationAdapter extends RecyclerView.Adapter<VacationAdapter.ViewHolder> {
    private List<VacationModel>models;

    public VacationAdapter(List<VacationModel> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public VacationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VacationModel model = models.get(position);
        holder.ivVacayPhoto.setBackgroundResource(model.getPhoto());
        holder.tvVacayPlaces.setText(model.getName());
        holder.tvVacayDesc.setText(model.getSummary());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(holder.itemView.getContext(), Details.class);
                a.putExtra("poto", model.getPhoto());
                a.putExtra("nama tempat", model.getName());
                a.putExtra("deskripsi", model.getSummary());
                holder.itemView.getContext().startActivity(a);
            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivVacayPhoto;
        TextView tvVacayPlaces;
        TextView tvVacayDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivVacayPhoto = itemView.findViewById(R.id.iv_photo);
            tvVacayPlaces = itemView.findViewById(R.id.tv_name);
            tvVacayDesc = itemView.findViewById(R.id.tv_sum);

        }
    }
}
