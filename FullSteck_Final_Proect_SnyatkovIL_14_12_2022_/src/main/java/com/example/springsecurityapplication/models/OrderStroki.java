package com.example.springsecurityapplication.models;

import com.example.springsecurityapplication.enumm.Status;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_stroki")
public class OrderStroki {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    ///////////@ManyToOne(optional = false)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private OrderShapki orderShapki;

    @ManyToOne(optional = false)
    private Product product;

    private int count;
    private float price;

    public OrderStroki() {
    }

//    public OrderStroki(Product product, int count, float price) {
//        this.product = product;
//        this.count = count;
//        this.price = price;
//    }

    public OrderStroki(OrderShapki orderShapki, Product product, int count, float price) {
        this.orderShapki = orderShapki;
        this.product = product;
        this.count = count;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderShapki getOrderShapki() {
        return orderShapki;
    }

    public void setOrderShapki(OrderShapki orderShapki) {
        this.orderShapki = orderShapki;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
