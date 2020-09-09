package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumCounter{
    private Statistics statistics;
    private int userCounter;
    private int postsCounter;
    private int commentsCounter;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public ForumCounter(Statistics statistics){
        this.statistics = statistics;
        calculateAdvStatistics();
    }
    public Stats calculateAdvStatistics(){
        userCounter = statistics.usersNames().size();
        postsCounter = statistics.postsCount();
        commentsCounter = statistics.commentsCount();
        if(userCounter != 0) {
            averagePostsPerUser =  (double) postsCounter / userCounter;
            averageCommentsPerUser = (double) commentsCounter / userCounter;
        } else {
            averagePostsPerUser = -1;
            averageCommentsPerUser = -1;
        }
        if(postsCounter > 0 && commentsCounter >= 0) {
            averageCommentsPerPost = (double) commentsCounter / postsCounter;
        } else {
            averageCommentsPerPost = -1;
        }
        return new Stats(userCounter, postsCounter, commentsCounter, averagePostsPerUser, averageCommentsPerUser, averageCommentsPerPost);
    }

    private void showStatistics() {
        System.out.println("Forum statistics");
        System.out.println("Number of users: " + userCounter);
        System.out.println("Number of posts: " + postsCounter);
        System.out.println("Number of comments: "+ commentsCounter);
        System.out.print("Average number of posts per user: ");
        if(userCounter == 0){
            System.out.println("Average number of posts per user: ERROR-Number of users = 0");
            System.out.println("Average number of comments per user: ERROR-Number of users = 0");
        }else {
            System.out.println("Average number of posts per user: " + averagePostsPerUser);
            System.out.println("Average number of comments per user: " + averageCommentsPerUser);
        }
        if(postsCounter <= 0){
            if(commentsCounter < 0){
                System.out.println("Average number of comments per post: ERROR-Number of posts <= 0 and number of comments < 0");
            }else {
                System.out.println("Average number of comments per post: ERROR-Number of posts <= 0");
            }
        }else {
            System.out.println("Average number of comments per post: " + averagePostsPerUser);
        }
    }
}

