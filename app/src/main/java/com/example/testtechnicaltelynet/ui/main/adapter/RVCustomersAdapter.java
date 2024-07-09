package com.example.testtechnicaltelynet.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testtechnicaltelynet.R;
import com.example.testtechnicaltelynet.data.Customer;
import com.example.testtechnicaltelynet.ui.main.filters.FilterBy;

import java.util.List;

public class RVCustomersAdapter extends RecyclerView.Adapter<RVCutomerViewHolder> implements Filterable {

    public List<Customer> mData;
    private FilterBy filterBy;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    public RVCustomersAdapter(Context context, List<Customer> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public RVCutomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item, parent, false);
        return new RVCutomerViewHolder(view, mClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RVCutomerViewHolder holder, int position) {
        String statusVisited = "No Visitado";
        Customer customer = mData.get(position);
        if (customer.getVisited()) {
            statusVisited = "Visitado";
        }
        holder.tvCode.setText(String.valueOf(customer.getCode()));
        holder.tvName.setText(customer.getName());
        holder.tvPhone.setText(customer.getPhone());
        holder.tvEmail.setText(customer.getEmail());
        holder.tvVisited.setText(statusVisited);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public Filter getFilter() {
        if (filterBy == null)
            filterBy = new FilterBy(this, mData);
        return filterBy;
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}
