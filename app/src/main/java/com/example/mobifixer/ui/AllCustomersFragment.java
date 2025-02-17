package com.example.mobifixer.ui;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobifixer.R;
import com.example.mobifixer.database.DatabaseHelper;
import java.util.ArrayList;
import java.util.List;

public class AllCustomersFragment extends Fragment {

    private DatabaseHelper databaseHelper;
    private RecyclerView recyclerView;
    private CustomerAdapter customerAdapter;

    public AllCustomersFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_customers, container, false);
        recyclerView = view.findViewById(R.id.customer_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        databaseHelper = new DatabaseHelper(requireContext());
        loadCustomers();

        return view;
    }

    private void loadCustomers() {
        Cursor cursor = databaseHelper.getAllCustomers();
        List<Customer> customerList = new ArrayList<>();

        while (cursor.moveToNext()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String phone = cursor.getString(2);
            String deviceModel = cursor.getString(3);
            String deliveryDate = cursor.getString(4);

            customerList.add(new Customer(id, name, phone, deviceModel, deliveryDate));
        }
        cursor.close();

        customerAdapter = new CustomerAdapter(customerList);
        recyclerView.setAdapter(customerAdapter);
    }
}
