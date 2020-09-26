package com.example.userlogin;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;

 
@RestController
public class Controller {
 
    @Autowired
    private UserService service;
    
    @Autowired
    private UserRepository userrepo;
    
    @Autowired
    private NotesRepository notesRepo;
    

    // RESTful API method for creating new user
    @PostMapping("/app/user")
    public ResponseEntity<?> add(@RequestBody User user) {
    	if(userrepo.getUserInfo(user.getUsername()) != null) {
    		return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
    	}
        service.save(user);
        return new ResponseEntity<>("status : account created", HttpStatus.CREATED);
        
    }
    
 // RESTful API method for login operation
    @PostMapping("/app/user/auth")
    public ResponseEntity<?> auth(@RequestBody User user) {
    	User existUser = service.getUserInfo(user.getUsername());
    	String responseString = "status : success, userId :  "+ existUser.getUserid();
    	return new ResponseEntity<>(responseString, HttpStatus.CREATED);
        
    }
    
 // RESTful API method for adding notes
    @PostMapping("/app/sites")
    public ResponseEntity<?> note(@RequestBody String note,
    		@RequestParam Integer user) {
    	Notes notes = new Notes();
    	notes.setNote(note);
    	notes.setUserid(user);
    	service.saveNote(notes);
    	return new ResponseEntity<>("status : success", HttpStatus.CREATED);
        
    }
    
    // RESTful API method for getting list of notes
    @GetMapping("/app/sites/list/")
	  public List<Notes> list(@RequestParam Integer user) {
	      return service.findAllNotes(user);
	  }
    
}