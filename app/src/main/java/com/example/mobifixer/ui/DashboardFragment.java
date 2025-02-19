package com.example.mobifixer.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import com.example.mobifixer.R;

public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Initialize buttons
        Button btnAllCustomers = view.findViewById(R.id.btn_all_customers);
        Button btnAddNewCustomer = view.findViewById(R.id.btn_add_customer);
        Button btnSearchCustomer = view.findViewById(R.id.btn_search_customer);

        // Set click listener for "All Customers" button
        btnAllCustomers.setOnClickListener(v -> {
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.nav_host_fragment, new AllCustomersFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        });

        // Set click listener to navigate to AddCustomerFragment
        btnAddNewCustomer.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_dashboardFragment_to_addCustomerFragment)
        );

        // Set click listener to navigate to SearchCustomerFragment
        btnSearchCustomer.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_dashboardFragment_to_searchCustomerFragment)
        );

        return view;
    }
}
