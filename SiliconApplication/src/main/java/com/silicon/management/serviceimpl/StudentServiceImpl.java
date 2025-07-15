package com.silicon.management.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silicon.management.model.Student;
import com.silicon.management.repository.StudentRepo;
import com.silicon.management.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void updateStudent(Long id, Student updatedStudent) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student existingStudent = optionalStudent.get();
            // Update fields (you can expand these as needed)
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAge(updatedStudent.getAge());
            existingStudent.setEmail(updatedStudent.getEmail());
            studentRepository.save(existingStudent);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with ID: " + id);
        }
    }

    // Stub implementations for other methods from the interface (to avoid errors)

    @Override
    public int getAgeByName(String name) {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public Student updateEmailById(Long id, String newEmail) {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public long countStudents() {
        return studentRepository.count();
    }

    @Override
    public boolean existsByName(String name) {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public List<Student> getStudentsByAge(int age) {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public List<Student> getStudentsByEmailDomain(String domain) {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public Student updateNameById(Long id, String newName) {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    @Override
    public List<String> getAllStudentNames() {
        throw new UnsupportedOperationException("Method not implemented yet");
    }
}
