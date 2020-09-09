package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDate;


public class Forum {
    private final List<ForumUser> forumUsers = new ArrayList<>();
    public Forum(){
        forumUsers.add(new ForumUser(1, "john", 'M', LocalDate.of(1993,1,11), 3));
        forumUsers.add(new ForumUser(2, "eve", 'F', LocalDate.of(1999,2,1), 0));
        forumUsers.add(new ForumUser(3, "robin", 'F', LocalDate.of(1982,6,15), 4));
        forumUsers.add(new ForumUser(4, "max", 'M', LocalDate.of(1971,8,16), 1));
        forumUsers.add(new ForumUser(5, "adam", 'M', LocalDate.of(1964,11,4), 0));
        forumUsers.add(new ForumUser(6, "jessi", 'F', LocalDate.of(2004,10,9), 0));
        forumUsers.add(new ForumUser(7, "sam", 'M', LocalDate.of(2010,2,16), 18));
        forumUsers.add(new ForumUser(8, "penny", 'F', LocalDate.of(1995,6,8), 24));
        forumUsers.add(new ForumUser(9, "howard", 'M', LocalDate.of(1945,3,1), 5));
        forumUsers.add(new ForumUser(10, "amy", 'F', LocalDate.of(1988,7,25), 1));
        forumUsers.add(new ForumUser(11, "leonard", 'M', LocalDate.of(1953,1,27), 6));
        forumUsers.add(new ForumUser(12, "rubi", 'F', LocalDate.of(1989,11,28), 2));
    }

    public List<ForumUser> getUserList(){return new ArrayList<>(forumUsers); }
}
