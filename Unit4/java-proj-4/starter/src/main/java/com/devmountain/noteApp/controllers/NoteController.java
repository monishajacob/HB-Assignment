package com.devmountain.noteApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devmountain.noteApp.dtos.NoteDto;
import com.devmountain.noteApp.services.NoteService;

public class NoteController {
	@Autowired
	private NoteService noteService;

	@GetMapping("/user/{userId}")
	public List<NoteDto> getNotesByUser(@PathVariable Long userId) {
		return noteService.getAllNotesByUserId(userId);
	}

	@GetMapping("/{noteId}")
	public Optional<NoteDto> getNoteById(@PathVariable Long noteId) {
		return noteService.getNoteById(noteId);
	}

	@PostMapping("/user/{userId}")
	public void addNote(@RequestBody NoteDto noteDto, @PathVariable Long userId) {
		noteService.addNote(noteDto, userId);
	}

	@DeleteMapping("/{noteId}")
	public void deleteNoteById(@PathVariable Long noteId) {
		noteService.deleteNoteById(noteId);
	}

	@PutMapping
	public void updateNote(@RequestBody NoteDto noteDto) {
		noteService.updateNoteById(noteDto);
	}

}
