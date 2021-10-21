/*
package com.zixiaoguo.cs635hw3.commands;


import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.DataSaveHelper;

import java.util.ArrayList;

public class SetBookCommand implements Command{

    private ArrayList<Book> oldBooks;
    private ArrayList<Book> newBooks;

    public SetBookCommand(ArrayList<Book> oldBooks, ArrayList<Book> newBooks) {
        this.oldBooks = oldBooks;
        this.newBooks = newBooks;
    }

    @Override
    public ArrayList<Book> execute() {
        oldBooks = newBooks;
        DataSaveHelper.saveCommand(this);
        return oldBooks;
    }

    @Override
    public String toString() {
        return "SetBookCommand{" +
                "oldBooks=" + oldBooks +
                ", newBooks=" + newBooks +
                '}';
    }
}

 */
