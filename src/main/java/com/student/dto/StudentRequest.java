package com.student.dto;

import java.util.List;

import com.student.model.Contact;
import com.student.model.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentRequest {

	private Student student;
	
	
}
