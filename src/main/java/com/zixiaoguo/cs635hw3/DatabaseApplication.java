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
        Inventory inventory = new InventoryDecorator(new BaseInventory());
        DataSaveHelper.setInventory(inventory);

        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        inventory.add(book1);
        inventory.add(book1);
        originator.setState(inventory.getBooks());
        caretaker.add(originator.createMemento());
        DataSaveHelper.saveMemento(inventory);//debug line
        inventory.add(book2);
        inventory.sell(book1);
        inventory.changePrice(book1, 5);
        //com.zixiaoguo.cs635hw3.inventory.setBooks(originator.restoreState(caretaker.get()));
        System.out.println(inventory);



        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(caretaker.getMomento());

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("myObjects.ser"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Memento memento1 = (Memento) oi.readObject();


            System.out.println(memento1.toString());

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Gson gson = new Gson();





    }
}
