package com.paper.papernote.api.util;

import com.paper.papernote.api.modelView.NoteViewModel;
import com.paper.papernote.core.model.Note;
import com.paper.papernote.core.repository.NoteBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleMapper {

    private static final ModelMapper modelMapper = new ModelMapper();
    private NoteBookRepository noteBookRepository;

    @Autowired
    public SimpleMapper(NoteBookRepository noteBookRepository) {
        this.noteBookRepository = noteBookRepository;
    }

    public NoteViewModel convertToNoteViewModel(Note entity) {
        return modelMapper.map(entity, NoteViewModel.class);
    }

    public Note convertToNoteEntity(NoteViewModel noteViewModel) {
        return modelMapper.map(noteViewModel, Note.class);
    }
}
