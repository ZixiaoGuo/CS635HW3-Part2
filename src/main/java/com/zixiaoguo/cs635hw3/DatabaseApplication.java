package com.zixiaoguo.cs635hw3;

import com.zixiaoguo.cs635hw3.inventory.BaseInventory;
import com.zixiaoguo.cs635hw3.inventory.Inventory;
import com.zixiaoguo.cs635hw3.inventory.InventoryDecorator;

import java.io.IOException;

public class DatabaseApplication {

    static void createState() throws IOException {
        Book book1 = new Book("firstBook", 10, IDGenerator.nextValue(), 1);
        Book book2 = new Book("SecondBook", 20, IDGenerator.nextValue(), 1);
        Book book3 = new Book("Encyclopedia Galatica", 20, IDGenerator.nextValue(), 1);
        Inventory inventory = new InventoryDecorator(new BaseInventory());


        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        DataSaveHelper.setParameters(inventory, caretaker, originator);

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
        inventory.add(book3);
        inventory.add(book3);
        System.out.println("This is the old inventory!!!!!!!!!!!!!!!" + inventory);
    }

    static void restoreState() throws IOException {
        Inventory inventory = new InventoryDecorator(new BaseInventory());
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        DataSaveHelper.setParameters(inventory, caretaker, originator);
        DataSaveHelper.restoreFromMemento(inventory);
        DataSaveHelper.restoreFromCommands();
        System.out.println("This is the NEW inventory**********************" + inventory);
    }

    public static void main(String[] args) throws IOException {

        createState();
        restoreState();

    }


}
