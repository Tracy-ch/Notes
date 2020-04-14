package com.example.notes;

public class NoteItem {

    private String title;
    private String description;


    public NoteItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
