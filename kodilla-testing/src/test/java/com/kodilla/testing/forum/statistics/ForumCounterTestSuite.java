package com.kodilla.testing.forum.statistics;

import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumCounterTestSuite {
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
    public void testNumberOfPostsEqual0Mock() {
        //Given
        Statistics statisticsMock  = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        userNames.add("user3");
        userNames.add("user4");
        userNames.add("user5");
        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        ForumCounter forumCounter = new ForumCounter(statisticsMock);
        Stats stats = new Stats(5,0,0,0,0,-1);

        //When
        Stats result = forumCounter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(stats, result);
    }

    @Test
    public void testNumberOfPostsEquals1000Mock() {
        //Given
        Statistics statisticsMock  = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        userNames.add("user3");
        userNames.add("user4");
        userNames.add("user5");

        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2);
        ForumCounter forumCounter = new ForumCounter(statisticsMock);
        Stats stats = new Stats(5,1000,2,200,0.4,0.002);

        //When
        Stats result = forumCounter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(stats, result);
    }

    @Test
    public void testNumberOfCommentsEquals0Mock() {
        //Given
        Statistics statisticsMock  = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(0);
        ForumCounter forumCounter = new ForumCounter(statisticsMock);
        Stats stats = new Stats(2,10,0,5,0,0);

        //When
        Stats result = forumCounter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(stats, result);
    }

    @Test
    public void testNumberOfCommentsIsLessThanNumbersOfPostsMock() {
        //Given
        Statistics statisticsMock  = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(5);
        ForumCounter forumCounter = new ForumCounter(statisticsMock);
        Stats stats = new Stats(2,10,5,5,2.5,0.5);

        //When
        Stats result = forumCounter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(result, stats);
    }

    @Test
    public void testNumberOfPostsIsLessThanNumbersOfCommentsMock() {
        //Given
        Statistics statisticsMock  = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        userNames.add("user1");
        userNames.add("user2");
        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(2);
        when(statisticsMock.commentsCount()).thenReturn(10);
        ForumCounter forumCounter = new ForumCounter(statisticsMock);
        Stats stats = new Stats(2,2,10,1,5,5);

        //When
        Stats result = forumCounter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(stats, result);
    }

    @Test
    public void testNumberOfUsersEquals0Mock() {
        //Given
        Statistics statisticsMock  = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);
        ForumCounter forumCounter = new ForumCounter(statisticsMock);
        Stats stats = new Stats(0,0,0,-1,-1,-1);

        //When
        Stats result = forumCounter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(stats, result);
    }

    @Test
    public void testNumberOfUsersEquals100Mock() {
        //Given
        Statistics statisticsMock  = mock(Statistics.class);
        List<String> userNames = new ArrayList<String>();
        for(int i=0; i<100; i++){
            userNames.add("a");
        }
        when(statisticsMock.usersNames()).thenReturn(userNames);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(50);
        ForumCounter forumCounter = new ForumCounter(statisticsMock);
        Stats stats = new Stats(100,10,50,0.1,0.5,5);

        //When
        Stats result = forumCounter.calculateAdvStatistics();

        //Then
        Assert.assertEquals(stats, result);
    }
}
