package com.zixiaoguo.cs635hw3;

import com.google.gson.Gson;
import com.zixiaoguo.cs635hw3.inventory.BaseInventory;
import com.zixiaoguo.cs635hw3.inventory.Inventory;
import com.zixiaoguo.cs635hw3.inventory.InventoryDecorator;

import java.io.*;

public class DatabaseApplication {

    public static void main(String[] args) {
        Book book1 = new Book("firstBook", 10, IDGenerator.nextValue(), 1);
        Book book2 = new Book("SecondBook", 20, IDGenerator.nextValue(), 1);
        Book book3 = new Book("Encyclopedia Galatica", 20, IDGenerator.nextValue(), 1);
        Inventory inventory = new InventoryDecorator(new BaseInventory());


        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        DataSaveHelper.setInventory(inventory, caretaker, originator);

        inventory.add(book1);
        inventory.add(book1);
        inventory.add(book2);
        inventory.sell(book1);
        inventory.add(book2);
        inventory.add(book2);
        inventory.add(book2);
        inventory.add(book2);
        inventory.add(book2);
        inventory.changePrice(book1, 5);
        //com.zixiaoguo.cs635hw3.inventory.setBooks(originator.restoreState(caretaker.get()));
        System.out.println(inventory);
        inventory.add(book2);
        System.out.println("Before restoration =================");
        DataSaveHelper.restoreFromMemento(inventory);
        DataSaveHelper.restoreFromCommands();
        System.out.println("NEw inventory" + inventory.getBooks());



    }
}
