package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;

import java.util.ArrayList;
import java.util.Objects;

public class AddBookCommand implements Command{

    private ArrayList<Book> books;
    private Book book;

    public AddBookCommand(ArrayList<Book> books, Book book) {
        this.books = books;
        this.book = book;
    }


    //TODO: call helper to save command after execution
    @Override
    public ArrayList<Book> execute(ArrayList<Book> books) {

        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.incrementQuantity();
                break;
            }
        }
        if (!found) {
            books.add(book);
            found = true;
        }
        DataSaveHelper.saveCommand(this);
        //System.out.println("Command saved" + this);
        return books;
    }

    @Override
    public String toString() {
        return "InsertBookCommand{" +
                "books=" + books +
                ", book=" + book +
                '}';
    }
}
