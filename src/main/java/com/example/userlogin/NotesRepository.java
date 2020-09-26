package com.example.userlogin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
	
	List<Notes> getAllNotesOfUser(Integer userID);
 
}