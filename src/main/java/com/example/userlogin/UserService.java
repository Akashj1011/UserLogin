package com.example.userlogin;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
 
    @Autowired
    private UserRepository userrepo;
    
    @Autowired
    private NotesRepository notesRepo;
     
    public List<User> listAll() {
        return userrepo.findAll();
    }
     
    public void save(User user) {
    	
    	userrepo.save(user);
    }
     
    public User get(Integer userID) {
        return userrepo.findById(userID).get();
    }

    public User getUserInfo(String username) {
        return userrepo.getUserInfo(username);
    }

    
    public void saveNote(Notes note) {
    	notesRepo.save(note);
    }
    
    public List<Notes> findAllNotes(Integer userID) {
    	return notesRepo.getAllNotesOfUser(userID);
    }
}