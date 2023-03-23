package com.devmountain.noteApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.devmountain.noteApp.dtos.NoteDto;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "Notes")
public class Note {

	public Note() {

	}

	public Note(NoteDto noteDto) {
		if (noteDto.getBody() != null) {
			this.body = noteDto.getBody();
		}
	}

	public Note(Long id, String body) {
		this.id = id;
		this.body = body;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "text")
	private String body;

	@ManyToOne
	@JsonBackReference
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
