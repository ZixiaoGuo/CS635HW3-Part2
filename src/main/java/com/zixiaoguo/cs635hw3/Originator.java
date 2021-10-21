package com.zixiaoguo.cs635hw3;

import java.util.ArrayList;

public class Originator {
    private ArrayList<Book> state = new ArrayList<>();

    public Memento createMemento(){
        return new Memento(state);
    }

    public void setState(ArrayList<Book> state) {
        this.state = state;
    }

    public ArrayList<Book> restoreState(Memento oldState){
        state = oldState.getState();
        System.out.println("restoring previous state: " + oldState);
        return state;
    }

}
