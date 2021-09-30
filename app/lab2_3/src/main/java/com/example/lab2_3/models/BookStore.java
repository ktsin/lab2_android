package com.example.lab2_3.models;

import java.util.ArrayList;

public class BookStore {
    private static ArrayList<Book> books;

    static {
        books = new ArrayList<>();

        books.add(new Book("1", "Book 0", "Author 0", "PublishCom.org", "1992", 1201, 12221, "leather-coated"));
        books.add(new Book("2", "Book 2", "Author 2", "pub.org", "2001", 1201, 123, "leather-coated"));
        books.add(new Book("3", "Book 3", "Author 12", "edu.org", "2002", 1201, 434, "leather-coated"));
        books.add(new Book("4", "Book 5", "Author 32", "PublishCom.org", "1993", 1201, 5443, "leather-coated"));
        books.add(new Book("5", "Book 6", "Author 29", "PublishCom.org", "1999", 1201, 4344, "leather-coated"));
        books.add(new Book("6", "Book 11", "Author 4", "geek#publish", "2016", 1201, 4353, "leather-coated"));
        books.add(new Book("7", "Book 3", "Author 21", "PublishCom.org", "1955", 1201, 3253, "leather-coated"));
        books.add(new Book("8", "Book 34", "Author 2", "geek#publish", "2008", 1201, 543, "leather-coated"));
        books.add(new Book("9", "Book 1", "Author 23", "PublishCom.org", "2020", 1201, 3244, "leather-coated"));
        books.add(new Book("0", "Book 9", "Author 45", "geek#publish", "2011", 1201, 4343, "leather-coated"));
    }

    public ArrayList<Book> getBooks(){
        return books;
    }

    public Book get(int position){
        return books.get(position);
    }

    public void remove(int position){
        books.remove(position);
    }
}
