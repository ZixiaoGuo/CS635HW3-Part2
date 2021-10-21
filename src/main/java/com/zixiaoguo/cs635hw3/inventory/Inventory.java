package com.zixiaoguo.cs635hw3.inventory;

import com.zixiaoguo.cs635hw3.Book;

import java.io.IOException;
import java.util.ArrayList;

public interface Inventory {

    public ArrayList<Book> getBooks();

    void setBooks(ArrayList<Book> books);

    public boolean addBook(String name, int price, int id) throws IOException;

    public boolean sellBook(String name) throws IOException;

    public void changePrice (String name, int newPrice) throws IOException;

    public int getPrice(int id);

    public int getPrice(String name);

    public String toString();

}
