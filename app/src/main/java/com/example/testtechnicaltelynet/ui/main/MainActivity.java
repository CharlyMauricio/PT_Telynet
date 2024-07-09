package com.example.testtechnicaltelynet.ui.main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.testtechnicaltelynet.data.Customer;
import com.example.testtechnicaltelynet.databinding.ActivityMainBinding;
import com.example.testtechnicaltelynet.ui.main.adapter.ItemClickListener;
import com.example.testtechnicaltelynet.ui.main.adapter.RVCustomersAdapter;
import com.example.testtechnicaltelynet.utils.DataListCustomersMock;
import com.example.testtechnicaltelynet.utils.SortBy;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ActivityMainBinding binding;
    private List<Customer> dataListCustomer;
    private RVCustomersAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataListCustomer = DataListCustomersMock.customerList();

        listener();
        initRecyclerView();
    }

    @Override
    public void onItemClick(View view, int position) {
        Customer customerSelect = dataListCustomer.get(position);
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:".concat(customerSelect.getPhone())));
        startActivity(intent);
    }

    private void initRecyclerView() {
        binding.rvCustomers.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RVCustomersAdapter(this, dataListCustomer);
        adapter.setClickListener(this);
        binding.rvCustomers.setAdapter(adapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void listener() {
        binding.buttonShowAll.setOnClickListener(view -> {
            adapter.mData.clear();
            adapter.mData.addAll(DataListCustomersMock.customerList());
            adapter.notifyDataSetChanged();
        });

        binding.buttonFilterIsVisited.setOnClickListener(view -> adapter.getFilter().filter("true"));

        binding.buttonFilterIsNotVisited.setOnClickListener(view -> adapter.getFilter().filter("false"));

        binding.buttonOrderByCode.setOnClickListener(view -> {
            dataListCustomer.sort(new SortBy.Code());
            adapter.notifyDataSetChanged();
        });

        binding.buttonOrderByName.setOnClickListener(view -> {
            dataListCustomer.sort(new SortBy.Name());
            adapter.notifyDataSetChanged();
        });
    }
}