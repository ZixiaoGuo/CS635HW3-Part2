package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;
import com.zixiaoguo.cs635hw3.IDGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class AddBookCommand implements Command{

    private String name;
    private int price;
    private int id;

    public AddBookCommand(String name, int price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }


    //TODO: call helper to save command after execution, change return value to boool
    @Override
    public ArrayList<Book> execute(ArrayList<Book> books) throws IOException {

        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getName(), name)) {
                found = true;
                bookIterator.incrementQuantity();
                break;
            }
        }
        if (!found) {
            Book book = new Book(name, price, id, 1);
            books.add(book);
        }
        DataSaveHelper.saveCommand(this);
        return books;
    }

    @Override
    public String toString() {
        return "AddBookCommand{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
