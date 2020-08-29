package com.kodilla.patterns2.observer.homework;

import java.net.URL;

public class Task {
    private final String name;
    private final URL link;

    public Task(String name, URL link) {
        this.name = name;
        this.link = link;
    }

    @Override
    public String toString() {
        return '\"' + name + '\"' + " (" + link + ')';
    }

    public String getName() {
        return name;
    }

    public URL getLink() {
        return link;
    }
}
