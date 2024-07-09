package com.demo_project.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.demo_project.entity.StudentsEntry;
import com.demo_project.repository.StudentsEntryRepository;

@Component
public class StudentsEntryService {
	@Autowired
	private StudentsEntryRepository studentsEntryRepository;	
		
	public void saveEntry(StudentsEntry studentsEntry) {
		studentsEntryRepository.save(studentsEntry);		
		
	}
	public List<StudentsEntry> getAll(){
		return studentsEntryRepository.findAll();	
	}
	public Optional<StudentsEntry> findByID(Long id) {
		return studentsEntryRepository.findById(id);
	}
	public void deleteEntry(Long id) {
	    studentsEntryRepository.deleteById(id);
	}

}
