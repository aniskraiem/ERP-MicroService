package com.esprit.note.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.note.Repository.NoteRepository;
import com.esprit.note.entities.Note;



@Service
public class NoteService implements INoteService {

	@Autowired
	NoteRepository ar;
	
	@Override
	public List<Note> retrieveAllNote() {
		List <Note> al =(List<Note>) ar.findAll();
		return al;
	}

	@Override
	public Note addNote(Note a) {
		return (Note) ar.save(a);
	}

	@Override
	public void deleteNote(Note a) {
		ar.deleteById(a.getId());
		
	}

	@Override
	public Note updateNote(Note a) {
		Note al = (Note) ar.save(a);
		return al;
	}

	@Override
	public Optional<Note> retrieveNote(int id) {
		Optional<Note> a=ar.findById(id);
		return a;
	}

}
