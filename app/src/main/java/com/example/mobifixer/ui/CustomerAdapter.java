package com.example.mobifixer.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobifixer.R;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private List<Customer> customerList;

    public CustomerAdapter(List<Customer> customerList) {
        this.customerList = customerList;
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
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    public static class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView tvCustomerId, tvCustomerName, tvPhone, tvDevice, tvDate;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCustomerId = itemView.findViewById(R.id.tv_customer_id);
            tvCustomerName = itemView.findViewById(R.id.tv_customer_name);
            tvPhone = itemView.findViewById(R.id.tv_customer_phone);
            tvDevice = itemView.findViewById(R.id.tv_customer_device);
            tvDate = itemView.findViewById(R.id.tv_customer_delivery);
        }
    }
}
