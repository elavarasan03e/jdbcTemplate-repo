package com.ibm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentContoller {
	
	@Autowired
	StudentRepo repo;
	
	@GetMapping("/students/count")
	int getCount() {
		return repo.getCountOfStudents();
	}
	
	@PostMapping("/students")
	void addStudent(@RequestBody Student students) {
		repo.addNewStudent(students);
	}

	@PutMapping("/students/{id}")
	void updateStudentbyid(@RequestBody Student student, @PathVariable int id) {
		repo.updateStudentbyId(student, id);
	}
	
	@DeleteMapping("/students/{id}")
	void DeleteStudentbyid(@PathVariable int id) {
		repo.deleteStudentById(id);
	}
	@GetMapping("/studetns/{id}")
	void ShowDetailsById(@PathVariable int id) {
		repo.DetailsofStudentById(id);
	}
}
