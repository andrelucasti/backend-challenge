package com.backendchalenger.store.model;

import java.time.LocalDate;

public class Order {

    private final String address;
    private final LocalDate confirmationDate;
    private final OrderStatus orderStatus;

    public Order(final String address, final LocalDate confirmationDate, final OrderStatus orderStatus) {
        this.address = address;
        this.confirmationDate = confirmationDate;
        this.orderStatus = orderStatus;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getConfirmationDate() {
        return confirmationDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}
