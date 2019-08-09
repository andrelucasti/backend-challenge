package com.backendchalenger.store.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "CONFIRMATION_DATE", nullable = false)
    private LocalDate confirmationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS", nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    private Store store;

    public Order(final String address, final LocalDate confirmationDate, final OrderStatus orderStatus, final Store store) {
        this.address = address;
        this.confirmationDate = confirmationDate;
        this.orderStatus = orderStatus;
        this.store = store;
    }

    public Long getId() {
        return id;
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

    public Store getStore() {
        return store;
    }
}
