package com.zixiaoguo.cs635hw3;

import com.zixiaoguo.cs635hw3.commands.Command;
import com.zixiaoguo.cs635hw3.inventory.BaseInventory;
import com.zixiaoguo.cs635hw3.inventory.Inventory;

import java.io.*;
import java.util.ArrayList;

public class DataSaveHelper {
    //TODO: add originator caretaker objects
    private static int commandCounter = 0;
    private static ArrayList<Command> commands = new ArrayList<>();
    private static Inventory inventory;

    private static Caretaker caretaker;
    private static Originator originator;


    public static void setInventory(Inventory inventory) {
        DataSaveHelper.inventory = inventory;
    }

    public static void saveCommand(Command command) {
        // save one memento every 10 commands
        if (commandCounter == 10) {
            saveMemento(inventory);
            commands.clear();
        }
        try {
            FileOutputStream f = new FileOutputStream(new File("savedCommand.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            commands.add(command);
            o.writeObject(commands);
            commandCounter++;


            o.close();
            f.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        }
        System.out.println("Command saved ------" + command);
    }

    //TODO: save memento rather than inventory
    public static void saveMemento(Inventory inventory) {
        ArrayList<Book> books = inventory.getBooks();
        try {
            FileOutputStream f = new FileOutputStream(new File("savedMemento.ser"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(books);

            o.close();
            f.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        }
        System.out.println("Memento saved ++++++" + inventory.getBooks());
    }


}
