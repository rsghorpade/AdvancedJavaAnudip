package com.example.StudentController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studEntity.Student;

@RestController
@RequestMapping("StudentData")
public class studController {
   
	
	private Map<Long, Student>studentEntry = new HashMap<>();
	
	//Create all data/list of student
	public List<Student> getAll (){
		return new ArrayList<>(studentEntry.values());
	}
	//data create  by using Post mapping  
	public boolean createEntry(@RequestBody Student myEntry ) {
		studentEntry.put(myEntry.getId(),  myEntry);
		       return true;
	}
	
	//get individual students data by their id
	@GetMapping("id/{myId}")
	public Student getStudentDataById(@PathVariable Long myId ) {
		return studentEntry.get(myId);
	}
	
	//delete individual students data by their id
	@DeleteMapping("id/{myId}")
	public Student deleteStudentById(@PathVariable Long myId) {
		return studentEntry.remove(myId);
	}

	//Update students  by their id
	@PutMapping("/id/{id}")
	public Student updateStudentById(@PathVariable Long id, Student myEntry) {
		return studentEntry.put(id, myEntry);
	//localhost:8080/id/67
	//@GetMapping("/xyz")
	//public String healthCheck() { 
		//return "Site is working";
		
		
	
}
}
