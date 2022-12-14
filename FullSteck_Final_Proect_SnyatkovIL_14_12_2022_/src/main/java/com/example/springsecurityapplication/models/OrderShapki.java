package com.example.springsecurityapplication.models;

import com.example.springsecurityapplication.enumm.Status;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_shapki")
public class OrderShapki {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String number;

    @Column(name = "order_number")
    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderShapki")
    private List<OrderStroki> orderStrokiList = new ArrayList<>();

    @ManyToOne(optional = false)
    private Person person;

    private int count;
    @Column(name = "price_total")
    private float priceTotal;

    private LocalDateTime dateTime;

//    private Status status;

    @ManyToOne(optional = false)
    private Statuses statusOrder;

    // Будем заполнять дату и время при создании объекта класса
    @PrePersist
    private void init(){
        dateTime = LocalDateTime.now();
    }


    // Метод по добавлению строк заказа в лист к текущему заказу (к шапке)
    public void addOrderStrokiToOrderShapki(OrderStroki orderStroki){
        orderStroki.setOrderShapki(this);
        orderStrokiList.add(orderStroki);
    }



    public OrderShapki() {
    }

//    public OrderShapki(String number, Person person, int count, float priceTotal, Status status) {
//        this.number = number;
//        this.person = person;
//        this.count = count;
//        this.priceTotal = priceTotal;
//        this.status = status;
//    }

    public OrderShapki(Statuses statusOrder) {
        this.statusOrder = statusOrder;
    }
    public OrderShapki(Person person, Statuses statusOrder) {
        this.person = person;
        this.statusOrder = statusOrder;
    }

    public OrderShapki(String number, String orderNumber, Person person, int count, float priceTotal, Statuses statusOrder) {
        this.number = number;
        this.orderNumber = orderNumber;
        this.person = person;
        this.count = count;
        this.priceTotal = priceTotal;
        this.statusOrder = statusOrder;
    }

//    public OrderShapki(String number, Person person, int count, float priceTotal, Status status, Statuses statusOrder) {
//        this.number = number;
//        this.person = person;
//        this.count = count;
//        this.priceTotal = priceTotal;
//        this.status = status;
//        this.statusOrder = statusOrder;
//    }
//
//    public OrderShapki(String number, Person person, Status status) {
//        this.number = number;
//        this.person = person;
//        this.status = status;
//    }


//    public OrderShapki(String number, List<OrderStroki> orderStrokiList, Person person, int count, float priceTotal, Status status, Statuses statusOrder) {
//        this.number = number;
//        this.orderStrokiList = orderStrokiList;
//        this.person = person;
//        this.count = count;
//        this.priceTotal = priceTotal;
//        this.status = status;
//        this.statusOrder = statusOrder;
//    }

    public OrderShapki(String number, String orderNumber, List<OrderStroki> orderStrokiList, Person person, int count, float priceTotal, Statuses statusOrder) {
        this.number = number;
        this.orderNumber = orderNumber;
        this.orderStrokiList = orderStrokiList;
        this.person = person;
        this.count = count;
        this.priceTotal = priceTotal;
        this.statusOrder = statusOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<OrderStroki> getOrderStrokiList() {
        return orderStrokiList;
    }

    public void setOrderStrokiList(List<OrderStroki> orderStrokiList) {
        this.orderStrokiList = orderStrokiList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(float priceTotal) {
        this.priceTotal = priceTotal;
    }

//    public Status getStatus() {
//        return status;
//    }
//
//    public void setStatus(Status status) {
//        this.status = status;
//    }


    public Statuses getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(Statuses statusOrder) {
        this.statusOrder = statusOrder;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
