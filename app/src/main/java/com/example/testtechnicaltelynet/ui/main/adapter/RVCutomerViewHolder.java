package com.example.testtechnicaltelynet.ui.main.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testtechnicaltelynet.R;

public class RVCutomerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView tvCode, tvName, tvPhone, tvEmail, tvVisited;
    private final ItemClickListener mClickListener;

    public RVCutomerViewHolder(View itemView, ItemClickListener listener) {
        super(itemView);

        mClickListener = listener;

        tvCode = itemView.findViewById(R.id.tvCode);
        tvName = itemView.findViewById(R.id.tvName);
        tvPhone = itemView.findViewById(R.id.tvPhone);
        tvEmail = itemView.findViewById(R.id.tvEmail);
        tvVisited = itemView.findViewById(R.id.tvVisited);

        tvPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
    }
}
