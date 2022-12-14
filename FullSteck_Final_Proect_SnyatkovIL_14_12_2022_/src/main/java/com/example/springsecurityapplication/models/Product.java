package com.example.springsecurityapplication.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false, columnDefinition = "text", unique = true)
    @NotEmpty(message = "Наименование товара не может быть пустым")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "text")
    @NotEmpty(message = "Описание товара не может быть пустым")
    private String description;

    @Column(name = "price", nullable = false)
    ///////////////////////@NotEmpty(message = "Цена товара не может быть пустым")
    @Min(value = 1, message = "Цена не может быть отрицательной или нулевой")
    private float price;

    private String city;

    private String sklad;

    @Column(name = "warehouse", nullable = false)
    @NotEmpty(message = "Склад по нахождению товара не может быть пустым")
    private String warehouse;

    @Column(name = "seller", nullable = false,columnDefinition = "text")
    @NotEmpty(message = "Информация о продавце не может быть пустым")
    private String seller;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> imageList = new ArrayList<>();

    private LocalDateTime dateTime;

    @ManyToOne(optional = false)
    private Category category;

    // Будем заполнять дату и время при создании объекта класса
    @PrePersist
    private void init(){
        dateTime = LocalDateTime.now();
    }

    @ManyToMany()
    @JoinTable(name = "product_cart", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> personList;

//    @OneToMany(mappedBy = "product")
//    private List<Order> orderList;

    @OneToMany(mappedBy = "product")
    private List<OrderStroki> orderStrokiList;

    // Метод по добавлению фотографий в лист к текущему продукту
    public void addImageToProduct(Image image){
        image.setProduct(this);
        imageList.add(image);
    }

//    public Product() {
//    }
//
//    public Product(String title, String description, float price, String city, String sklad, String warehouse, String seller, List<Image> imageList, Category category) {
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.city = city;
//        this.sklad = sklad;
//        this.warehouse = warehouse;
//        this.seller = seller;
//        this.imageList = imageList;
//        this.category = category;
//    }

//    public Product(int id, String title, String description, float price, String city, String sklad, String warehouse, String seller) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.price = price;
//        this.city = city;
//        this.sklad = sklad;
//        this.warehouse = warehouse;
//        this.seller = seller;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSklad() {
        return sklad;
    }

    public void setSklad(String sklad) {
        this.sklad = sklad;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
