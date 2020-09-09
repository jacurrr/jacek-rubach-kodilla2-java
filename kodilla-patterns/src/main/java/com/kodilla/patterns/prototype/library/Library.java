package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;
import com.kodilla.patterns.prototype.TasksList;

import java.util.HashSet;
import java.util.Set;

public class Library extends Prototype {
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBook(Book book){
        books.remove(book);
    }


    public Library shallowCopy() throws  CloneNotSupportedException{
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException{
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for(Book theBook : books){
            clonedLibrary.books.add(new Book(theBook.getTitle(),theBook.getAuthor(),theBook.getPublicationDate()));
        }
        return clonedLibrary;
    }

    public String toString(){
        String s = name + "]\n";
        for(Book theBook : books) {
            s = s + theBook.toString() + "\n";
        }
        return s;
    }
}
