package com.silicon.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.silicon.management.model.Student;
import com.silicon.management.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Student API", description = "Operations related to student management")
@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired // dependency injection
	StudentService studentService;
	public StudentController() {
	    System.out.println("StudentController initialized");
	}
	/**
	 * this method is for add student
	 * 
	 * @param student
	 * @return
	 */
	@PostMapping
	 public Student addStudent(@RequestBody Student student) {
        System.out.println("Received: " + student);
        return studentService.addStudent(student);
    }
	/**
	 * this method is for get student
	 * 
	 * @return
	 */
	@GetMapping("/getAllStudent")
	public List<Student> getStudents() {
		List<Student> students = studentService.fetchStudent();
		return students;
	}
	 @GetMapping("/{id}")
	    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	        Student student = studentService.getStudentById(id)
	                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
	        return ResponseEntity.ok(student);
	    }

	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
	    studentService.updateStudent(id, student);
	    return ResponseEntity.ok("Student updated successfully!");
	}


	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
	    try {
	        studentService.deleteStudent(id);
	        return ResponseEntity.ok("Student deleted successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting student: " + e.getMessage());
	    }
	}

}
