package com.zixiaoguo.cs635hw3.inventory;

import com.zixiaoguo.cs635hw3.Book;
import com.zixiaoguo.cs635hw3.IDGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class BaseInventory implements Inventory {
    //TODO: make the methods call the invoker to create the commands and finish the rest
    //TODO: probably also change the memento to auto save after the command call 10 times

    private ArrayList<Book> books;

    public BaseInventory() {
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    // used for memento to restore state
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public boolean addBook(String name, int price, int id) throws IOException {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getName(), name)) {
                found = true;
                bookIterator.incrementQuantity();
                break;
            }
        }
        if (!found) {
            Book book = new Book(name, price, id, 1);
            books.add(book);
        }
        return true;

    }

    public boolean sellBook(String name) {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getName(), name) && bookIterator.getQuantity() > 0) {
                found = true;
                bookIterator.decrementQuantity();
                break;
            }
        }
        if (!found) {
            throw new NoSuchElementException("No book with this name in the inventory");
        }
        return found;
    }

    public void changePrice (String name, int newPrice) {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getName(), name)) {
                bookIterator.setPrice(newPrice);
                break;
            }
        }
    }

    public int getPrice(int id) {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), id)) {
                return bookIterator.getPrice();
            }
        }
        throw new NoSuchElementException(); //if not found, throw exception
    }

    public int getPrice(String name) {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getName(), name)) {
                return bookIterator.getPrice();
            }
        }
        throw new NoSuchElementException(); //if not found, throw exception
    }

    @Override
    public String toString() {
        return "main.Inventory{" +
                "books=" + books +
                '}';
    }



}
