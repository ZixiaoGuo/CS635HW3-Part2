package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class SellBookCommand implements Command{

    private Book book;

    public SellBookCommand(Book book) {
        this.book = book;
    }


    @Override
    public ArrayList<Book> execute(ArrayList<Book> books) throws IOException {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.decrementQuantity();
                break;
            }
        }
        DataSaveHelper.saveCommand(this);
        return books;
    }

    @Override
    public String toString() {
        return "SellBookCommand{" +
                "book=" + book +
                '}';
    }
}
