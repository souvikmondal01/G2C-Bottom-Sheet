package com.kivous.g2cbottomsheet;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.ItemViewHolder> {

    private List<HorizontalObject> listItem;
    private IClickListener iClickListener;

    private static int lastClickedPosition = -1;
    private int selectedItem;

    public HorizontalAdapter(List<HorizontalObject> listItem, IClickListener iClickListener) {
        this.listItem = listItem;
        this.iClickListener = iClickListener;
        selectedItem = 0;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final HorizontalObject horizontalObject = listItem.get(position);
        holder.tvItem.setText(horizontalObject.getName());
        holder.tvDescription.setText(horizontalObject.getDescription());
        holder.tvCost.setText(horizontalObject.getCost());

        holder.tvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickListener.clickItem(horizontalObject);

            }
        });
//        holder.tvDescription.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iClickListener.clickItem(itemObject);
//
//            }
//        });
//        holder.tvCost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                iClickListener.clickItem(itemObject);
//
//            }
//        });


        holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.border2));
        if (selectedItem == position) {
            holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.border));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(view.getContext(), itemObject.getCost(), Toast.LENGTH_SHORT).show();

                int previousItem = selectedItem;
                selectedItem = position;

                notifyItemChanged(previousItem);
                notifyItemChanged(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItem;
        private TextView tvDescription;
        private TextView tvCost;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tv_item);
            tvDescription = itemView.findViewById(R.id.tv_ssa_description);
            tvCost = itemView.findViewById(R.id.tv_ssa_cost);

        }
    }
}
