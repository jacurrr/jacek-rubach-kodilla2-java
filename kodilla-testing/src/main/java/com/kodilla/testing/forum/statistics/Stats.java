package com.kodilla.testing.forum.statistics;

public class Stats {
    private int userCounter;
    private int postsCounter;
    private int commentsCounter;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public Stats(int userCounter, int postsCounter, int commentsCounter, double averagePostsPerUser, double averageCommentsPerUser, double averageCommentsPerPost) {
        this.userCounter = userCounter;
        this.postsCounter = postsCounter;
        this.commentsCounter = commentsCounter;
        this.averagePostsPerUser = averagePostsPerUser;
        this.averageCommentsPerUser = averageCommentsPerUser;
        this.averageCommentsPerPost = averageCommentsPerPost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stats)) return false;

        Stats stats = (Stats) o;

        if (userCounter != stats.userCounter) return false;
        if (postsCounter != stats.postsCounter) return false;
        if (commentsCounter != stats.commentsCounter) return false;
        if (Double.compare(stats.averagePostsPerUser, averagePostsPerUser) != 0) return false;
        if (Double.compare(stats.averageCommentsPerUser, averageCommentsPerUser) != 0) return false;
        return Double.compare(stats.averageCommentsPerPost, averageCommentsPerPost) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = userCounter;
        result = 31 * result + postsCounter;
        result = 31 * result + commentsCounter;
        temp = Double.doubleToLongBits(averagePostsPerUser);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(averageCommentsPerUser);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(averageCommentsPerPost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
