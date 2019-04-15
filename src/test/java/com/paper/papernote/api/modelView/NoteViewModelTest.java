package com.paper.papernote.api.modelView;

import com.paper.papernote.core.model.Note;
import com.paper.papernote.core.model.NoteBook;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Date;

import static org.junit.Assert.*;

public class NoteViewModelTest {

    private static final ModelMapper modelMapper = new ModelMapper();

    @Test
    public void checkIfModelMapperCanTransferViewModelToEntity() {
        //given
        NoteViewModel noteViewModel = new NoteViewModel();
        noteViewModel.setId(1L);
        noteViewModel.setTitle("Sample title");
        noteViewModel.setText("Sample text");
        noteViewModel.setCreateDate(new Date("29/09/2019"));
        noteViewModel.setNoteBookId("1");
        noteViewModel.setNoteBookName("notebook name");
        //when
        Note note = modelMapper.map(noteViewModel, Note.class);
        //then
        assertEquals(noteViewModel.getId(), note.getId());
        assertEquals(noteViewModel.getTitle(), note.getTitle());
        assertEquals(noteViewModel.getText(), note.getText());
        assertEquals(noteViewModel.getCreateDate(), note.getCreateDate());
        assertEquals(noteViewModel.getNoteBookId(), String.valueOf(note.getNoteBook().getId()));
        assertEquals(noteViewModel.getNoteBookName(), note.getNoteBook().getName());
    }

    @Test
    public void checkIfModelMapperCanTransferEntityToModelView() {
        //given
        NoteBook noteBook = new NoteBook(1L,"name");

        Note note = new Note();
        note.setId(1L);
        note.setTitle("Sample title");
        note.setText("Sample text");
        note.setCreateDate(new Date("29/09/2019"));
        note.setNoteBook(noteBook);
        //when
        NoteViewModel noteViewModel = modelMapper.map(note, NoteViewModel.class);
        //then
        assertEquals(note.getId(), noteViewModel.getId());
        assertEquals(note.getTitle(), noteViewModel.getTitle());
        assertEquals(note.getText(), noteViewModel.getText());
        assertEquals(note.getCreateDate(), noteViewModel.getCreateDate());
        assertEquals(note.getNoteBook().getId(), Long.parseLong(noteViewModel.getNoteBookId()));
        assertEquals(note.getNoteBook().getName(), noteViewModel.getNoteBookName());
    }
}