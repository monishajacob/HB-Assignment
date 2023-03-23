package com.devmountain.noteApp.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.devmountain.noteApp.dtos.NoteDto;

public interface NoteService {

	Optional<NoteDto> getNoteById(Long noteId);

	void addNote(NoteDto noteDto, Long userId);

	void updateNoteById(NoteDto noteDto);

	void deleteNoteById(Long noteId);

	List<NoteDto> getAllNotesByUserId(Long userId);

}