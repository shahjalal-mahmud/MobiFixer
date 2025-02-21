package com.example.mobifixer.ui;

import android.app.DatePickerDialog;
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
import java.util.Calendar;
import java.util.Random;

public class AddCustomerFragment extends Fragment {

    private EditText etCustomerName, etPhoneNumber, etDeviceModel;
    private TextView tvDeliveryDate, tvCustomerId;
    private DatabaseHelper databaseHelper;

    public AddCustomerFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_customer, container, false);

        databaseHelper = new DatabaseHelper(requireContext());

        // Initialize Views
        tvCustomerId = view.findViewById(R.id.tv_customer_id);
        etCustomerName = view.findViewById(R.id.et_customer_name);
        etPhoneNumber = view.findViewById(R.id.et_customer_phone);
        etDeviceModel = view.findViewById(R.id.et_device_model);
        tvDeliveryDate = view.findViewById(R.id.tv_delivery_date);
        Button btnSelectDate = view.findViewById(R.id.btn_select_date);
        Button btnSaveCustomer = view.findViewById(R.id.btn_save_customer);

        // Generate a unique ID
        tvCustomerId.setText(generateUniqueId());

        btnSelectDate.setOnClickListener(v -> showDatePicker());
        btnSaveCustomer.setOnClickListener(v -> saveCustomer());

        return view;
    }

    private void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(),
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                    tvDeliveryDate.setText(selectedDate);
                }, year, month, day);

        datePickerDialog.show();
    }

    private void saveCustomer() {
        String id = tvCustomerId.getText().toString();
        String name = etCustomerName.getText().toString();
        String phone = etPhoneNumber.getText().toString();
        String deviceModel = etDeviceModel.getText().toString();
        String deliveryDate = tvDeliveryDate.getText().toString();

        if (name.isEmpty() || phone.isEmpty() || deviceModel.isEmpty() || deliveryDate.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean inserted = databaseHelper.insertCustomer(id, name, phone, deviceModel, deliveryDate);

        if (inserted) {
            Toast.makeText(requireContext(), "Customer added successfully!", Toast.LENGTH_SHORT).show();
            resetFields(); // Reset form
        } else {
            Toast.makeText(requireContext(), "Failed to add customer", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetFields() {
        etCustomerName.setText("");
        etPhoneNumber.setText("");
        etDeviceModel.setText("");
        tvDeliveryDate.setText("");
        tvCustomerId.setText(generateUniqueId()); // Generate a new unique ID for the next customer
    }

    private String generateUniqueId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // Allowed characters
        StringBuilder uniqueId = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            uniqueId.append(chars.charAt(random.nextInt(chars.length())));
        }

        return uniqueId.toString(); // Returns a 6-character alphanumeric ID
    }
}
