package com.silicon.management.service;

import java.util.List;
import java.util.Optional;

import com.silicon.management.model.Staff;

/*
 * Service interface for managing Staff entities
 */
public interface StaffService {

    // Add a new staff member
    public Staff addStaff(Staff staff);

    // Fetch list of all staff members
    public List<Staff> fetchStaff();

    // Update a staff member's details by ID
    public void updateStaff(Long id, Staff staff);

    // Get age of a staff member by name
    public int getAgeByName(String name);

    // Get a staff member by ID
    public Optional<Staff> getStaffById(Long id);

    // Delete a staff member by ID
    public void deleteStaff(Long id);

    // Update a staff member's email by ID
    public Staff updateEmailById(Long id, String newEmail);

    // Count total number of staff members
    public long countStaff();

    // Check if a staff member exists by name
    public boolean existsByName(String name);

    // Get a list of staff members by age
    public List<Staff> getStaffByAge(int age);

    // Get a list of staff members by email domain (like '@gmail.com')
    public List<Staff> getStaffByEmailDomain(String domain);

    // Update staff member's name by ID
    public Staff updateNameById(Long id, String newName);

    // Delete all staff members
    public void deleteAllStaff();

    // Get list of staff names only
    public List<String> getAllStaffNames();
}
