package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int ID;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private int postCounter;

    public ForumUser(int ID, String username, char sex, LocalDate birthDate, int postCounter) {
        this.ID = ID;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.postCounter = postCounter;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", postCounter=" + postCounter +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostCounter() {
        return postCounter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser)) return false;

        ForumUser forumUser = (ForumUser) o;

        if (getID() != forumUser.getID()) return false;
        if (getSex() != forumUser.getSex()) return false;
        if (getPostCounter() != forumUser.getPostCounter()) return false;
        if (getUsername() != null ? !getUsername().equals(forumUser.getUsername()) : forumUser.getUsername() != null)
            return false;
        return getBirthDate() != null ? getBirthDate().equals(forumUser.getBirthDate()) : forumUser.getBirthDate() == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        return result;
    }
}
