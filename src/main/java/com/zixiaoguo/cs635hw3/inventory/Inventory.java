package com.zixiaoguo.cs635hw3.inventory;

import com.zixiaoguo.cs635hw3.Book;

import java.util.ArrayList;

public interface Inventory {

    public ArrayList<Book> getBooks();

    void setBooks(ArrayList<Book> books);

    public boolean add(Book book);

    public boolean sell(Book book);

    public void changePrice (Book book, int newPrice);

    public int getPrice(int id);

    public int getPrice(String name);

    public String toString();

}
