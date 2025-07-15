package com.silicon.management.service;

import java.util.List;
import java.util.Optional;

import com.silicon.management.model.Student;

/*
 * here you need to return the age of the student
 * @param name
 * @return
 * 
 */
 
public interface StudentService {
	
	public Student addStudent(Student student);
	
	public List<Student> fetchStudent();
	 // Get age of a student by name
    public void updateStudent( Long id,Student student);

    public int getAgeByName(String name);

    // Get a student by ID
    public Optional<Student> getStudentById(Long id);

    // Delete a student by ID
    public void deleteStudent(Long id);

    // Update a student's email by ID
    public Student updateEmailById(Long id, String newEmail);

    // Count total number of students
    public long countStudents();

    // Check if a student exists by name
    public boolean existsByName(String name);

    // Get a list of students by age
    public List<Student> getStudentsByAge(int age);

    // Get a list of students by email domain (like '@gmail.com')
    public List<Student> getStudentsByEmailDomain(String domain);

    // Update student's name by ID
    public Student updateNameById(Long id, String newName);

    // Delete all students
    public void deleteAllStudents();

    // Get list of student names only
    public List<String> getAllStudentNames();
} 