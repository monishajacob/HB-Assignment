package com.devmountain.noteApp.dtos;

import java.io.Serializable;

import com.devmountain.noteApp.entities.Note;
import com.devmountain.noteApp.entities.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class NoteDto implements Serializable {
	private Long id;
	private String body;
	private UserDto userDto;

	public NoteDto(Note note) {
		if (note.getId() != null) {
			this.id = note.getId();

		}
		if (note.getBody() != null) {

			this.body = note.getBody();
		}

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
