package com.paper.papernote.core.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Note {
    @Id
    private long id;
    private String title;
    private String text;
    private Date createDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private NoteBook noteBook;

    public Note() {
        this.createDate = new Date();
    }

    public Note(String title, String text, NoteBook noteBook) {
        this();
        this.title = title;
        this.text = text;
        this.noteBook = noteBook;
    }

    public Note(long id, String title, String text, NoteBook noteBook) {
        this(title, text, noteBook);
        if (id > 0) {
            this.id = id;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public NoteBook getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(NoteBook noteBook) {
        this.noteBook = noteBook;
    }
}
