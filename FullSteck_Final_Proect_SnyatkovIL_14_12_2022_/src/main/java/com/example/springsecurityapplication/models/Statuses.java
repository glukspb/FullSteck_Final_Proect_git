package com.example.springsecurityapplication.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "statuses")
public class Statuses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "statusOrder")
    private List<OrderShapki> ordersShapki;

    public Statuses() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderShapki> getOrdersShapki() {
        return ordersShapki;
    }

    public void setOrdersShapki(List<OrderShapki> ordersShapki) {
        this.ordersShapki = ordersShapki;
    }
}
