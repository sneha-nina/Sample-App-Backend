package com.silicon.management.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Represents a student entity containing personal and academic details")
@Entity
@Table(name = "student")
public class Student {

	@Schema(
	        description = "The unique identifier of the student (auto-generated, read-only)",
	        example = "1",
	        accessMode = Schema.AccessMode.READ_ONLY
	    )
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "The full name of the student", example = "Sneha Sahu")
    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @Schema(description = "The age of the student", example = "21")
    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    @Schema(description = "The email address of the student", example = "sneha.sahu@example.com")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
