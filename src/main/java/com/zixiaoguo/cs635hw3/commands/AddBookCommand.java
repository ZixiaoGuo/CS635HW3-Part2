package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class AddBookCommand implements Command{

    private Book book;

    public AddBookCommand(Book book) {
        this.book = book;
    }


    //TODO: call helper to save command after execution, change return value to boool
    @Override
    public ArrayList<Book> execute(ArrayList<Book> books) throws IOException {

        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.incrementQuantity();
                break;
            }
        }
        if (!found) {
            book.setQuantity(1);    // prevent incorrect quantity when recovering state from command
            books.add(book);
            found = true;
        }
        DataSaveHelper.saveCommand(this);
        //System.out.println("Command saved" + this);
        return books;
    }

    @Override
    public String toString() {
        return "AddBookCommand{" +
                "book=" + book +
                '}';
    }
}
