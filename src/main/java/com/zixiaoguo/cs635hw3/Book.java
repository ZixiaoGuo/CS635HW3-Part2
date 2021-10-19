package com.zixiaoguo.cs635hw3;

import java.io.Serializable;

public class Book implements Serializable {
    private String name;
    private int price;
    private int id;
    private int quantity;

    public Book(String name, int price, int id, int quantity) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity () {
        quantity++;
    }

    public void decrementQuantity () {
        quantity--;
    }

    @Override
    public String toString() {
        return "main.com.zixiaoguo.cs635hw3.Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
