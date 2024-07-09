package com.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo_project.entity.StudentsEntry;

public interface StudentsEntryRepository extends JpaRepository<StudentsEntry, Long>{

}
