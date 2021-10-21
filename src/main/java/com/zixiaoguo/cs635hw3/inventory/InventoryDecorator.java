package com.zixiaoguo.cs635hw3.inventory;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.IDGenerator;
import com.zixiaoguo.cs635hw3.commands.*;

import java.io.IOException;
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
        //Command setBookCommand = new SetBookCommand(inventory.getBooks(), books);
        //setBookCommand.execute();
        inventory.setBooks(books);
        //TODO: fix the command

    }

    @Override
    public boolean addBook(String name, int price, int id) throws IOException {
        //Maybe Command cmd = new InsertBookCommand(inventory.getBooks())
        //then inventory.setBooks(cmd.execute(inventory.getBooks)
        //System.out.println("Before Insertion: " + inventory.getBooks());
        Command cmd = new AddBookCommand(name, price, id);
        //inventory.setBooks(cmd.execute());
        cmd.execute(inventory.getBooks());
        //System.out.println(inventory.getBooks() + "AFTER INSERTION");
        //TODO: maybe move save statement here
        return true;
    }

    @Override
    public boolean sellBook(String name) throws IOException {
        Command cmd = new SellBookCommand(name);
        cmd.execute(inventory.getBooks());
        return true;
    }

    @Override
    public void changePrice(String name, int newPrice) throws IOException {
        //inventory.changePrice(book, newPrice);
        Command cmd = new ChangePriceCommand(name, newPrice);
        cmd.execute(inventory.getBooks());
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
