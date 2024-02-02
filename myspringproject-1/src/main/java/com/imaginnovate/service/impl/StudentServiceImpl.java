package com.imaginnovate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginnovate.model.Student;
import com.imaginnovate.model.StudentMarks;
import com.imaginnovate.repo.StudentMarksRepo;
import com.imaginnovate.repo.StudentRepository;
import com.imaginnovate.service.IStudentService;
import com.imaginnovate.utils.StudentDetailsValidator;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	StudentMarksRepo studentMarksRepo;

	@Override
	public String registerStudent(Student student) throws Exception {
		String response=null;
		if(!StudentDetailsValidator.isValidAge(student.getAge())) {
			response="Inavalid Age ,should be greater than 10";
			return response;
		}
		Student savedStudent = studentRepo.save(student);
		 response = "Student details registered with roll no " + savedStudent.getRollNo();

		return response;
	}

	@Override
	public String updateStudent(Student student) throws Exception {
		// TODO Auto-generated method stub
		Student updatedStudent = studentRepo.save(student);
		String response = "Student details updated with roll no " + updatedStudent.getRollNo();
		return response;
	}

	@Override
	public Student getStudentById(int rollNo) {
		Student student = studentRepo.getById(rollNo);
		return student;
	}

//	@Override
//	public String registerStudent(Student student) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String getStudentDetails(Student student) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudentdetails() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepo.findAll();
		return students;
	}

	@Override
	public String deleteStudentdetailsById(int rollNo) {
		studentRepo.deleteById(rollNo);
		String response = "Student record deleted with rollNo " + rollNo;
		return response;
	}

	@Override
	public List<Student> getlistofAllStudent(int standard) {
		List<Student> students = studentRepo.findByClass(standard);
		return students;
	}

	@Override
	public List<Student> getlistofAllStudent(int startAge, int endAge) {
		List<Student> students = studentRepo.findByAge(startAge,endAge);
		return students;
		
	}

	@Override
	public String registerMarks(StudentMarks studentMarks) {
		
		String response=null;
		if(!StudentDetailsValidator.isValidMark(studentMarks)) {
			response="Inavalid Marks";
			return response;
		}
		StudentMarks savedStudentMarks = studentMarksRepo.save(studentMarks);
		 response = "Student details registered with roll no " + savedStudentMarks.getRollNo();

		return response;
	}

//	@Override
//	public String updateStudent(Student student) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
