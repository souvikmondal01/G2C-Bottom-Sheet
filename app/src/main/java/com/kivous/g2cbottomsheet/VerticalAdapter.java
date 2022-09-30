package com.kivous.g2cbottomsheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.PacViewHolder> {

    private List<VerticalObject> pacListItem;

    public VerticalAdapter(List<VerticalObject> pacListItem) {
        this.pacListItem = pacListItem;
    }

    @NonNull
    @Override
    public PacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_item,parent,false);
        return new PacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PacViewHolder holder, int position) {
        VerticalObject verticalObject = pacListItem.get(position);
//        holder.ivItemPac.setImageResource(pacItemObject.getPacImage());
        holder.tvItemNamePac.setText(verticalObject.getPacName());
        holder.tvItemDescriptionPac.setText(verticalObject.getPacDescription());
        holder.tvItemCostPac.setText(verticalObject.getPacCost());

        holder.btnAddPac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), verticalObject.getPacName()+" is clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return pacListItem.size();
    }

    public class PacViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivItemPac;
        private TextView tvItemNamePac;
        private TextView tvItemDescriptionPac;
        private TextView tvItemCostPac;
        private Button btnAddPac;

        public PacViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItemPac = itemView.findViewById(R.id.iv_item_pac);
            tvItemNamePac = itemView.findViewById(R.id.tv_item_name_pac);
            tvItemDescriptionPac = itemView.findViewById(R.id.tv_item_description_pac);
            tvItemCostPac = itemView.findViewById(R.id.tv_item_cost_pac);
            btnAddPac = itemView.findViewById(R.id.btn_add_pac);
        }
    }
}
