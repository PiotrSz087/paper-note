package com.paper.papernote.core.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NoteBook {
    @Id
    private long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook", cascade = CascadeType.ALL)
    private List<Note> notes;

    NoteBook() {
        this.notes = new ArrayList<>();
    }

    public NoteBook(String name) {
        this();
        this.name = name;
    }

    public NoteBook(long id, String name) {
        this();
        if (id > 0) {
            this.id = id;
        }
        this.name = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
