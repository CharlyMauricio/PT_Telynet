package com.example.testtechnicaltelynet.ui.main.filters;

import android.widget.Filter;

import com.example.testtechnicaltelynet.data.Customer;
import com.example.testtechnicaltelynet.ui.main.adapter.RVCustomersAdapter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FilterBy extends Filter {

    private final RVCustomersAdapter adapter;
    private final List<Customer> originalList;
    private final List<Customer> filteredList;

    public FilterBy(RVCustomersAdapter adapter, List<Customer> originalList) {
        super();
        this.adapter = adapter;
        this.originalList = new LinkedList<>(originalList);
        this.filteredList = new ArrayList<>();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        filteredList.clear();
        final FilterResults results = new FilterResults();
        if (constraint.length() == 0) {
            filteredList.addAll(originalList);
        } else {
            final String filterPattern = constraint.toString().toLowerCase().trim();
            for (final Customer customer : originalList) {
                if (String.valueOf(customer.getVisited()).contains(filterPattern)) {
                    filteredList.add(customer);
                }
            }
        }
        results.values = filteredList;
        results.count = filteredList.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.mData.clear();
        adapter.mData.addAll((ArrayList<Customer>) results.values);
        adapter.notifyDataSetChanged();
    }
}