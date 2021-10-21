package com.zixiaoguo.cs635hw3;

import java.io.Serializable;
import java.util.ArrayList;

public class Memento implements Serializable {
    private ArrayList<Book> state;

    protected Memento(ArrayList<Book> state) {
        this.state = state;
    }

    protected ArrayList<Book> getState() {
        return state;
    }

    @Override
    public String toString() {
        return "main.com.zixiaoguo.cs635hw3.Memento{" +
                "state=" + state +
                '}';
    }
}
