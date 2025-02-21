package com.example.mobifixer.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobifixer.R;
import com.example.mobifixer.database.DatabaseHelper;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Customer> customerList;
    private DatabaseHelper databaseHelper; // DatabaseHelper instance
    private Context context;

    public CustomerAdapter(Context context, List<Customer> customerList) {
        this.context = context;
        this.customerList = customerList;
        this.databaseHelper = new DatabaseHelper(context); // Initialize DatabaseHelper
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = customerList.get(position);
        holder.tvCustomerId.setText(customer.getId());
        holder.tvCustomerName.setText(customer.getName());
        holder.tvPhone.setText(customer.getPhone());
        holder.tvDevice.setText(customer.getDeviceModel());
        holder.tvDate.setText(customer.getDeliveryDate());

        // Handle delete button click
        holder.btnDelete.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Delete Customer")
                    .setMessage("Are you sure you want to delete this customer?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        if (databaseHelper.deleteCustomer(customer.getId())) {
                            customerList.remove(position); // Remove from list
                            notifyItemRemoved(position); // Notify RecyclerView
                            Toast.makeText(context, "Customer deleted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
        });
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView tvCustomerId, tvCustomerName, tvPhone, tvDevice, tvDate;
        Button btnDelete; // Add button reference

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCustomerId = itemView.findViewById(R.id.tv_customer_id);
            tvCustomerName = itemView.findViewById(R.id.tv_customer_name);
            tvPhone = itemView.findViewById(R.id.tv_customer_phone);
            tvDevice = itemView.findViewById(R.id.tv_customer_device);
            tvDate = itemView.findViewById(R.id.tv_customer_delivery);
            btnDelete = itemView.findViewById(R.id.btn_delete); // Initialize delete button
        }
    }
}
