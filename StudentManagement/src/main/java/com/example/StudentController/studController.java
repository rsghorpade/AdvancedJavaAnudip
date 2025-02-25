package com.example.StudentController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudEntity.Student;

@RestController
@RequestMapping("/studData")
public class studController {

	private Map<Long, Student> studentEntry = new HashMap<>();

//	public StudentController() {
//		studentEntry.put(1L, new Student(1L, "Avinash", 1));
//		studentEntry.put(2L, new Student(2L, "Vikas", 2));
//		studentEntry.put(3L, new Student(3L, "Pravin", 3));
//	}

	// getting all the data or list of students.
	@GetMapping
	public List<Student> getAll() {
		return new ArrayList<>(studentEntry.values());
	}

	// Data created by using post mapping
	@PostMapping
	public Student createEntry(@RequestBody Student myEntry) {
		studentEntry.put(myEntry.getId(), myEntry);
		return myEntry;
	}

	// Get individual students data by their id
	@GetMapping("/id/{myId}")
	public Student getStudentsDataById(@PathVariable Long myId) {
		return studentEntry.get(myId);

	}

	// delete students individually by their id
	@DeleteMapping("/id/{myId}")
	public Student deleteSStudentById(@PathVariable Long myId) {
		return studentEntry.remove(myId);
	}

	// Update
	@PutMapping("/id/{id}")
	public Student updateStudentById(@PathVariable Long id, @RequestBody Student myEntry) {
		return studentEntry.put(id, myEntry);
	}

}

		
//	//localhost:8080/id/67
//	//@GetMapping("/xyz")
//	//public String healthCheck() { 
//		//return "Site is working";
//		
		
	


