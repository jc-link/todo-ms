package com.todoms.todoms.model;

public class Task {
    private int id;
    private String name;
    private String description;
    private boolean completed;

    public Task() {

    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        completed = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
