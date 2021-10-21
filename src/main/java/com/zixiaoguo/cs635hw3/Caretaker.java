package com.zixiaoguo.cs635hw3;

public class Caretaker {

    private Memento savedStates;


    public void add(Memento state) {
        savedStates = state;
    }

    public Memento getMomento() {
        return savedStates;
    }
}
