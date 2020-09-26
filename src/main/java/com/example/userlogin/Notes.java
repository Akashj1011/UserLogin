package com.example.userlogin;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
 
@Entity

@NamedQuery(name = "Notes.getAllNotesOfUser",
query = "SELECT e FROM Notes e WHERE userid =?1 "
)
public class Notes {
    private Integer userid;
    private String note;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noteid;

 
    public Notes() {
    }
 
    public Notes(Integer userid, String note, Integer noteid) {
        this.userid = userid;
        this.noteid = noteid;
        this.note = note;
    }

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	
	public Integer getNoteid() {
		return noteid;
	}

	public void setNoteid(Integer noteid) {
		this.noteid = noteid;
	}

    
	 
}