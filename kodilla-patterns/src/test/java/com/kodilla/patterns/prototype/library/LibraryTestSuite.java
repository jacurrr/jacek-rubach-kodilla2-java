package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks(){
        //Given
        Book book1 = new Book("Perfekcyjna niedoskonałość", "Jacek Dukaj", LocalDate.of(2004,12,8));
        Book book2 = new Book("Hobbit", "J.R.R. Tolkien", LocalDate.of(1961,1,1));
        Book book3 = new Book("Taniec Śmierci", "Lautell K. Hamilton", LocalDate.of(2010,6,29));
        Book book4 = new Book("Gniazdo światów", "Marek S. Huberath", LocalDate.of(1999,1,1));
        Library library = new Library("Library number 1");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Library clonedLibrary = null;
        try{
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library number 2");
        }catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        Book book5 = new Book("Miasto Kości","Cassandra Clare",LocalDate.of(2007,4,1));
        library.addBook(book5);
        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(5, library.getBooks().size());
        Assert.assertEquals(5, clonedLibrary.getBooks().size());
        Assert.assertEquals(4, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}
