package com.paper.papernote.api.modelView;

import javax.validation.constraints.NotNull;

public class NoteBookViewModel {
    private String id;
    @NotNull
    private String name;
    private int noteBookNotes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoteBookNotes() {
        return noteBookNotes;
    }

    public void setNoteBookNotes(int noteBookNotes) {
        this.noteBookNotes = noteBookNotes;
    }
}
