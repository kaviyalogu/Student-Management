package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.student.dto.StudentResponse;
import com.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	@Query("SELECT new com.student.dto.StudentResponse(s.fullName, c.cname) FROM Student s JOIN s.contacts c")
	public List<StudentResponse> getJoinInformation();
	
	/*@Query("UPDATE Student ")
	public boolean updateStudentdetails();*/
}
