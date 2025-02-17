package com.example.mobifixer.ui;

public class Customer {
    private String id, name, phone, deviceModel, deliveryDate;

    public Customer(String id, String name, String phone, String deviceModel, String deliveryDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.deviceModel = deviceModel;
        this.deliveryDate = deliveryDate;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getDeviceModel() { return deviceModel; }
    public String getDeliveryDate() { return deliveryDate; }
}
