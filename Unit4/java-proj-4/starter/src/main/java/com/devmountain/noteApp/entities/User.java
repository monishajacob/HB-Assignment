package com.devmountain.noteApp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devmountain.noteApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Users")
public class User {

	public User() {
	}

	public User(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(UserDto userDto) {

		if (userDto.getPassword() != null) {
			this.password = userDto.getPassword();

		}
		if (userDto.getUsername() != null) {
			this.password = userDto.getUsername();

		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // check Long

	@Column(unique = true)
	private String username;

	@Column
	private String password;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JsonManagedReference
	private Set<Note> noteSet = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Note> getNoteSet() {
		return noteSet;
	}

	public void setNoteSet(Set<Note> noteSet) {
		this.noteSet = noteSet;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
