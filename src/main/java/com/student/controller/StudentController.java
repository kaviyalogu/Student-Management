package com.student.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentRequest;
import com.student.dto.StudentResponse;
import com.student.model.Student;
import com.student.repository.ContactRepository;
import com.student.repository.StudentRepository;

@RestController
@Transactional
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@PostMapping("/save")
	public Student saveStudentdetails(@RequestBody StudentRequest s) {
		return studentRepository.save(s.getStudent());
	}
	
	@GetMapping("/all")
	public List<Student> getallStudents(){
		return studentRepository.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<Student> getoneStudent(@PathVariable("id") int rollNo){
		return studentRepository.findById(rollNo);
	}
	
	@GetMapping("/getinfo")
	public List<StudentResponse> getJoinInfo(){
		return studentRepository.getJoinInformation();
	}
	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int rollNo, @RequestBody Student s) {
	         if(studentRepository.existsById(rollNo)) 
	         {
	          studentRepository.save(s);
	          return "Student updated";
	          		}
	         else {
	        	 return "Student Id is not present";
	         }
	        }
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int rollNo) {
		if(studentRepository.existsById(rollNo)) {
			studentRepository.deleteById(rollNo);
			return "Student deleted";
		}
		else {
			return "Student Id is not present";
		}
		
	}
}
