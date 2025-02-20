package com.example.mobifixer.ui;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.mobifixer.R;
import com.example.mobifixer.database.DatabaseHelper;

public class SearchCustomerFragment extends Fragment {
    private EditText etPhone;
    private Button btnSearch;
    private TextView tvResult;
    private DatabaseHelper databaseHelper;

    public SearchCustomerFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_customer, container, false);

        // Initialize UI components
        etPhone = view.findViewById(R.id.et_phone);
        btnSearch = view.findViewById(R.id.btn_search);
        tvResult = view.findViewById(R.id.tv_result);

        // Initialize database
        databaseHelper = new DatabaseHelper(requireContext());

        // Set click listener for search button
        btnSearch.setOnClickListener(v -> searchCustomer());

        return view;
    }

    @SuppressLint("SetTextI18n")
    private void searchCustomer() {
        String phone = etPhone.getText().toString().trim();
        if (phone.isEmpty()) {
            Toast.makeText(getContext(), "Please enter a phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor cursor = databaseHelper.searchCustomerByPhone(phone);
        if (cursor.moveToFirst()) {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String device = cursor.getString(3);
            String date = cursor.getString(4);

            // Display customer details
            tvResult.setText(
                    String.format("ID: %s\nName: %s\nPhone: %s\nDevice: %s\nDelivery Date: %s", id, name, phone, device, date)
            );
        } else {
            tvResult.setText("@string/no_customer_found");
        }
        cursor.close();
    }
}
