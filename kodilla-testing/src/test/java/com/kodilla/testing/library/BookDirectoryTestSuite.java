package com.kodilla.testing.library;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished");
    }

    @Before
    public void  beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo","John Smith",2008);
        Book book2 = new Book("Secretaries and Directors","Dilbert Michigan",2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz",2016);
        Book book4 = new Book("Secret of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionsMoreThan20() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultOf0Books = new ArrayList<Book>();
        List<Book> resultOf15Books = generateListOfNBooks(15);
        List<Book> resultOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                .thenReturn(resultOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        assertEquals(0,theListOfBooks0.size());
        assertEquals(15,theListOfBooks15.size());
        assertEquals(0,theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    private  List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 0; n < booksQuantity; n++) {
            Book theBook = new Book("Title" + n,"Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksBorrowedByUser() {
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser libraryUser1 = new LibraryUser("John", "Smith", "99111111111");
        LibraryUser libraryUser2 = new LibraryUser("Adam", "Snow", "88112233333");
        LibraryUser libraryUser3 = new LibraryUser("Lilith", "Black", "77031544444");
        List<Book> resultOf0Books = new ArrayList<Book>();
        List<Book> resultOf1Books = generateListOfNBooks(1);
        List<Book> resultOf5Books = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser1))
                .thenReturn(resultOf0Books);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2))
                .thenReturn(resultOf1Books);
        when(libraryDatabaseMock.listBooksInHandsOf(libraryUser3))
                .thenReturn(resultOf5Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksInHandsOf(libraryUser1);
        List<Book> theListOfBooks1 = bookLibrary.listBooksInHandsOf(libraryUser2);
        List<Book> theListOfBooks5 = bookLibrary.listBooksInHandsOf(libraryUser3);

        //Then
        assertEquals(0,theListOfBooks0.size());
        assertEquals(1,theListOfBooks1.size());
        assertEquals(5,theListOfBooks5.size());
    }
}
