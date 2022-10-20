package com.esprit.note.Services;
import java.util.List;
import java.util.Optional;

import com.esprit.note.entities.Note;



public interface INoteService {
	List<Note> retrieveAllNote();
	Note addNote(Note a);
	void deleteNote(Note a);
	Note updateNote(Note a);
	Optional<Note> retrieveNote(int id);
}
