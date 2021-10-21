package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ChangePriceCommand implements Command{


    private String name;
    private int newPrice;

    public ChangePriceCommand(String name,int newPrice) {
        this.name = name;
        this.newPrice = newPrice;
    }

    @Override
    public ArrayList<Book> execute(ArrayList<Book> books) throws IOException {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getName(), name)) {
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
                "name='" + name + '\'' +
                ", newPrice=" + newPrice +
                '}';
    }
}
