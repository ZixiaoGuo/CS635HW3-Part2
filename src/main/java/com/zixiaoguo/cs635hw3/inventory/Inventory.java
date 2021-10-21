package com.zixiaoguo.cs635hw3.inventory;

import com.zixiaoguo.cs635hw3.Book;

import java.io.IOException;
import java.util.ArrayList;

public interface Inventory {

    public ArrayList<Book> getBooks();

    void setBooks(ArrayList<Book> books);

    public boolean add(Book book) throws IOException;

    public boolean sell(Book book) throws IOException;

    public void changePrice (Book book, int newPrice) throws IOException;

    public int getPrice(int id);

    public int getPrice(String name);

    public String toString();

}
