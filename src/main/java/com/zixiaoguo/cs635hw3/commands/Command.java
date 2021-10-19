package com.zixiaoguo.cs635hw3.commands;

import com.zixiaoguo.cs635hw3.Book;

import java.io.Serializable;
import java.util.ArrayList;

public interface Command extends Serializable {

    public ArrayList<Book> execute();

}