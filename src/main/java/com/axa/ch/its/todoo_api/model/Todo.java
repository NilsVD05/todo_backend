package com.axa.ch.its.todoo_api.model;


import lombok.Data;

@Data
public class Todo {
    long id;
    long userId;
    String title;
    boolean completed;

    public Todo(long id, long userId, String title, boolean completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }
}

