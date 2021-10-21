package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SellBookCommand implements Command{

    private String name;

    public SellBookCommand(String name) {
        this.name = name;
    }


    @Override
    public ArrayList<Book> execute(ArrayList<Book> books) throws IOException {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getName(), name) && bookIterator.getQuantity() > 0) {
                found = true;
                bookIterator.decrementQuantity();
                break;
            }
            else if (Objects.equals(bookIterator.getName(), name) && bookIterator.getQuantity() <= 0) {
                throw new NoSuchElementException("the book you want to sell does not exist");
            }
        }
        DataSaveHelper.saveCommand(this);
        return books;
    }

    @Override
    public String toString() {
        return "SellBookCommand{" +
                "name='" + name + '\'' +
                '}';
    }
}
