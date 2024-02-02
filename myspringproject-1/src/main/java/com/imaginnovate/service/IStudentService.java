package com.imaginnovate.service;

import java.util.List;

import com.imaginnovate.model.Student;
import com.imaginnovate.model.StudentMarks;

public interface IStudentService {
	
	public String registerStudent(Student student) throws Exception;

//	public String updateStudentById(Student student)throws Exception;
	
	public String getStudentDetails(Student student)throws Exception;

//	public String getStudentdetailsByRollno(Student student)throws Exception;

	String updateStudent(Student student) throws Exception;

	public Student getStudentById(int rollNo)throws Exception;

	public List<Student> getAllStudentdetails();

	public String deleteStudentdetailsById(int rollNo);

	public List<Student> getlistofAllStudent(int standard);

	public List<Student> getlistofAllStudent(int startAge, int endAge);

	public String registerMarks(StudentMarks studentMarks);

//	public Student findByRollNo(String rollNo);

//	public StudentMarks getStudentDetailsByRollNo(String rollNo);





	
}
