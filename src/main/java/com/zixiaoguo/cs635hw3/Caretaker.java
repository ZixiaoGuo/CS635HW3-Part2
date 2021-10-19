package com.zixiaoguo.cs635hw3;

public class Caretaker {
    /*
    private ArrayList<main.com.zixiaoguo.cs635hw3.Memento>  savedStates = new ArrayList<>();


    public void add(main.com.zixiaoguo.cs635hw3.Memento state) {
        savedStates.add(state);
    }

    public main.com.zixiaoguo.cs635hw3.Memento get(int index) {
        return savedStates.get(index);
    }

     */
    private Memento savedStates;


    public void add(Memento state) {
        savedStates = state;
    }

    public Memento getMomento() {
        return savedStates;
    }
}
