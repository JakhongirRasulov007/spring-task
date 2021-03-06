package com.mastery.testspringproductmicroservice.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Order_product") // order in SQL is a reserved work, therefore, name of a table is changed
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @NotNull(message = "date in Order table cannot be null")
    private LocalDate date;

//     many to one relationship with Customer
    @ManyToOne(cascade = CascadeType.ALL) // owning side of the relationship between Customer and Order tables
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToOne(mappedBy = "order") // inverse side of the relationship between Invoice and Order tables
    private Invoice invoice;

    @OneToMany(mappedBy = "order") // inverse side of the relationship between Detail and Order tables
    @JsonIgnore // resolves infinite recursion
    private List<Detail> details;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
