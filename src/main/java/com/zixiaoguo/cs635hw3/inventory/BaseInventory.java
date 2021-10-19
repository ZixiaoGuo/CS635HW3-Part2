package com.zixiaoguo.cs635hw3.inventory;

import com.zixiaoguo.cs635hw3.Book;

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

    public boolean add(Book book) {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.incrementQuantity();
                break;
            }
        }
        if (!found) {
            books.add(book);
            found = true;
        }

        return found;
    }


    public boolean sell(Book book) {
        boolean found = false;
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
                found = true;
                bookIterator.decrementQuantity();
                break;
            }
        }
        return found;
    }

    public void changePrice (Book book, int newPrice) {
        for (Book bookIterator : books) {
            if (Objects.equals(bookIterator.getId(), book.getId())) {
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
