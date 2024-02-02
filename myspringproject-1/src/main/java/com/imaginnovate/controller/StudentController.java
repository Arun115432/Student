package com.imaginnovate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PatchExchange;

import com.imaginnovate.model.Student;
import com.imaginnovate.model.StudentMarks;
import com.imaginnovate.service.IStudentService;

@RestController
@RequestMapping("/api/v1")

public class StudentController {

	@Autowired
	IStudentService studentService;

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Student student) {

		try {
			String response = studentService.registerStudent(student);
			return new ResponseEntity<String>(response, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PatchExchange("/update")
	public ResponseEntity<String> update(@RequestBody Student student) {

		try {
			String response = studentService.updateStudent(student);
			return new ResponseEntity<String>(response, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping("/details")
	public ResponseEntity<?> getAllStudentDetails(@RequestParam("rollNo") int rollNo) {

		try {
			Student student = studentService.getStudentById(rollNo);
			return new ResponseEntity<Student>(student, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	/*
	 * @GetMapping("/getdetailsByrollno") public ResponseEntity<String>
	 * getStudentDetails(@RequestBody Student student) {
	 * 
	 * try { String response = studentService.getStudentdetailsByRollno(student);
	 * return new ResponseEntity<String>(response, HttpStatus.OK);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); return new
	 * ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * } }
	 */
	@GetMapping("/alldetails")
	public ResponseEntity<?> getAllStudentDetails() {

		try {
			List< Student > students = studentService.getAllStudentdetails();
			return new ResponseEntity<>(students, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteStudentDetails(@RequestParam("rollNo") int rollNo) {

		try {
			String response = studentService.deleteStudentdetailsById(rollNo);
			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/class/{class}")
	public ResponseEntity<?> getlistofAllStudent(@PathVariable("class") int standard) {

		try {
			List< Student > students = studentService.getlistofAllStudent(standard);
			return new ResponseEntity<>(students, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@GetMapping("/age/{startAge}/{endAge}")
	public ResponseEntity<?> getStudentsBetweenAgeRange(@PathVariable("startAge") int startAge,@PathVariable("endAge") int endAge) {

		try {
			List< Student > students = studentService.getlistofAllStudent( startAge,endAge);
			return new ResponseEntity<>(students, HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	@PostMapping("/registerMarks")
	public ResponseEntity<String> registerMarks(@RequestBody StudentMarks studentMarks) {

		try {
			String response = studentService.registerMarks(studentMarks);
			return new ResponseEntity<String>(response, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
}

