package com.esprit.note.Repository;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.note.entities.Note;




@Repository
public interface NoteRepository extends CrudRepository<Note,Integer> {

}
