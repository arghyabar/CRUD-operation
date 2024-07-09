package com.demo_project.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo_project.entity.StudentsEntry;
import com.demo_project.service.StudentsEntryService;

@RestController
@RequestMapping("/link")		
public class StudentsEntryController {
	@Autowired
	private StudentsEntryService studentsEntryService; 

	@GetMapping
	public List <StudentsEntry> getAll(){
		return studentsEntryService.getAll();
	}
	
	@PostMapping
	
	public StudentsEntry createEntry(@RequestBody StudentsEntry myentry) {
		studentsEntryService.saveEntry(myentry);			
		return myentry;
	}

	@GetMapping("id/{myID}")
	public StudentsEntry getJournalEntryByID(@PathVariable long myID){	
		Optional <StudentsEntry> journalEntry = studentsEntryService.findByID(myID);
        return journalEntry.orElse(null);
	}
	
	@DeleteMapping("id/{myID}")
	public boolean deleteJournalEntryByID(@PathVariable long myID){	
		return true;
	}
	
	@PutMapping("/id/{id}")
	public StudentsEntry updateStudentEntryByID(@PathVariable long id, @RequestBody StudentsEntry newEntry) {
		Optional<StudentsEntry> oldEntry = studentsEntryService.findByID(id);
		if (oldEntry.isPresent()) {
			StudentsEntry updatedEntry = oldEntry.get();
			updatedEntry.setName(newEntry.getName());
			updatedEntry.setPhone(newEntry.getPhone());
			updatedEntry.setEmail(newEntry.getEmail());
			updatedEntry.setStream(newEntry.getStream());
			studentsEntryService.saveEntry(updatedEntry);
			return updatedEntry;
		} else {
			return null;
		}
		
	}

}
