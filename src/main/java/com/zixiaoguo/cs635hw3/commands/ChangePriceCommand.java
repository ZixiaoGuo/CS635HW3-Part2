package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;

import java.util.ArrayList;
import java.util.Objects;

public class ChangePriceCommand implements Command{

    private ArrayList<Book> books;
    private Book book;
    private int newPrice;

    public ChangePriceCommand(ArrayList<Book> books, Book book,int newPrice) {
        this.books = books;
        this.book = book;
        this.newPrice = newPrice;
    }

    @Override
    public ArrayList<Book> execute() {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                bookIterator.setPrice(newPrice);
                break;
            }
        }
        DataSaveHelper.saveCommand(this);
        return books;
    }

    @Override
    public String toString() {
        return "ChangePriceCommand{" +
                "books=" + books +
                ", book=" + book +
                ", newPrice=" + newPrice +
                '}';
    }
}
