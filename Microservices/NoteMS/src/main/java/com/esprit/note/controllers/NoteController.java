package com.esprit.note.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.note.Services.INoteService;
import com.esprit.note.entities.*;



@RestController
public class NoteController {
	@Autowired
	INoteService achatService;
	
	//http://localhost:8085/SpringMVC/servlet/allNote
	//@CrossOrigin(origins ="*")
	@GetMapping("/allNote")
	@ResponseBody
	public List<Note> getUsers(){
		List<Note> l=achatService.retrieveAllNote();
		return l;
	}
	
	@PostMapping("/addNote")
	@ResponseBody
	public Note addAchat(@RequestBody Note a) {
		return achatService.addNote(a);
	}
	
	@PostMapping("/deleteNote")
	@ResponseBody
	public void deleteAchat(@RequestBody Note a) {
		achatService.deleteNote(a);
	}
	
	@GetMapping("/getNote/{id}")
	@ResponseBody
	public Optional<Note> getUser(@PathVariable(value = "id")int id){
		Optional<Note> a=achatService.retrieveNote(id);
		return a;
	}
	
	@PostMapping("/updateNote")
	@ResponseBody
	public Note updateAchat(@RequestBody Note a) {
		return achatService.updateNote(a);
	}
	
		
}
