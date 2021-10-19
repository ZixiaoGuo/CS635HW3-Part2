package com.zixiaoguo.cs635hw3.inventory;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.commands.*;

import java.util.ArrayList;

public class InventoryDecorator implements Inventory{

    private Inventory inventory;

    public InventoryDecorator(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public ArrayList<Book> getBooks() {
        return inventory.getBooks();
    }

    @Override
    public void setBooks(ArrayList<Book> books) {
        Command setBookCommand = new SetBookCommand(inventory.getBooks(), books);
        setBookCommand.execute();

    }

    @Override
    public boolean add(Book book) {
        //Maybe Command cmd = new InsertBookCommand(inventory.getBooks())
        //then inventory.setBooks(cmd.execute(inventory.getBooks)
        //System.out.println("Before Insertion: " + inventory.getBooks());
        Command cmd = new AddBookCommand(inventory.getBooks(), book);
        //inventory.setBooks(cmd.execute());
        cmd.execute();
        //System.out.println(inventory.getBooks() + "AFTER INSERTION");
        //TODO: maybe move save statement here
        return true;
    }

    @Override
    public boolean sell(Book book) {
        Command cmd = new SellBookCommand(inventory.getBooks(), book);
        System.out.println("Before deletion: " + inventory.getBooks());
        cmd.execute();
        System.out.println(inventory.getBooks() + "AFTER DELETION");
        return true;
    }

    @Override
    public void changePrice(Book book, int newPrice) {
        //inventory.changePrice(book, newPrice);
        Command cmd = new ChangePriceCommand(inventory.getBooks(), book, newPrice);
        cmd.execute();
    }

    @Override
    public int getPrice(int id) {
        return inventory.getPrice(id);
    }

    @Override
    public int getPrice(String name) {
        return inventory.getPrice(name);
    }

    @Override
    public String toString() {
        return "InventoryDecorator{" +
                "inventory=" + inventory +
                '}';
    }
}
