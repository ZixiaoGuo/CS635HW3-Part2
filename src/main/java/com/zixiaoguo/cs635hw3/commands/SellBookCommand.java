package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;

import java.util.ArrayList;
import java.util.Objects;

public class SellBookCommand implements Command{

    private ArrayList<Book> books;
    private Book book;

    public SellBookCommand(ArrayList<Book> books, Book book) {
        this.books = books;
        this.book = book;
    }


    @Override
    public ArrayList<Book> execute() {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.decrementQuantity();
                break;
            }
        }
        return books;
    }

    @Override
    public String toString() {
        return "SellBookCommand{" +
                "books=" + books +
                ", book=" + book +
                '}';
    }
}
