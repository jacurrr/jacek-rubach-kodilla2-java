package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Book book1 = new Book("aut1","tit1",2000,"123");
        Book book2 = new Book("aut2","tit2",2001,"1234");
        Book book3 = new Book("aut3","tit3",2002,"12345");
        Book book4 = new Book("aut4","tit4",2003,"123456");
        Set<Book> bookSetEven = new HashSet<>();
        Set<Book> bookSetOdd = new HashSet<>();
        bookSetEven.add(book1);
        bookSetEven.add(book2);
        bookSetEven.add(book3);
        bookSetEven.add(book4);
        bookSetOdd.add(book1);
        bookSetOdd.add(book2);
        bookSetOdd.add(book3);
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        double medianEven = medianAdapter.publicationYearMedian(bookSetEven);
        double medianOdd = medianAdapter.publicationYearMedian(bookSetOdd);
        //Then
        Assert.assertEquals(2001.5,medianEven,0.00001);
        Assert.assertEquals(2001,medianOdd,0.00001);
    }
}