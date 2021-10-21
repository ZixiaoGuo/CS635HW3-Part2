package com.zixiaoguo.cs635hw3;

import com.zixiaoguo.cs635hw3.inventory.BaseInventory;
import com.zixiaoguo.cs635hw3.inventory.Inventory;
import com.zixiaoguo.cs635hw3.inventory.InventoryDecorator;

import java.io.IOException;

public class DatabaseApplication {

    static void createState() throws IOException {

        String book1 = "firstBook";
        String book2 = "secondBook";
        String book3 = "Encyclopedia Galatica";
        String book4 = "4thBook";
        String book5 = "5thBook";
        int book1Id = IDGenerator.nextValue();
        int book2Id = IDGenerator.nextValue();
        int book3Id = IDGenerator.nextValue();
        int book4Id = IDGenerator.nextValue();
        int book5Id = IDGenerator.nextValue();
        Inventory inventory = new InventoryDecorator(new BaseInventory());


        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        DataSaveHelper.setParameters(inventory, caretaker, originator);

        //I have to use ID as one of the parameters, or it will cause inconsistency issue
        //When recovering from commands
        inventory.addBook(book1, 10, book1Id);
        inventory.addBook(book1, 10, book1Id);
        inventory.addBook(book2, 20, book2Id);
        inventory.sellBook(book1);
        inventory.addBook(book2, 20, book2Id);
        inventory.addBook(book2, 20, book2Id);
        inventory.addBook(book2, 20, IDGenerator.nextValue());
        inventory.addBook(book2, 20, IDGenerator.nextValue());
        inventory.addBook(book2, 20, IDGenerator.nextValue());
        inventory.changePrice(book1, 5);
        inventory.addBook(book3, 30, IDGenerator.nextValue());
        inventory.addBook(book3, 30, IDGenerator.nextValue());
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
