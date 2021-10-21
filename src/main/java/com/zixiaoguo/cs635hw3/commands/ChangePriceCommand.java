package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ChangePriceCommand implements Command{


    private Book book;
    private int newPrice;

    public ChangePriceCommand(Book book,int newPrice) {
        this.book = book;
        this.newPrice = newPrice;
    }

    @Override
    public ArrayList<Book> execute(ArrayList<Book> books) throws IOException {
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
                "book=" + book +
                ", newPrice=" + newPrice +
                '}';
    }
}
